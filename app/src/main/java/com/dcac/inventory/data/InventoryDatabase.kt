package com.dcac.inventory.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//InventoryDatabase is the central class of the Room database.
//It provides a singleton instance of the database via `getDatabase()`, and exposes the necessary DAOs,
//here `itemDao()`, to interact with the `Item` table.
// This class uses Room to:
//- Access local data (via the DAO).
//- Insert, modify, or delete `Item` objects.
//- Persist data even after the application is closed.

//Whenever i change the database table schema, i need to increase the version number.
//i don't keep the schema in the version history.
@Database(entities = [Item::class], version = 1, exportSchema = false)
abstract class InventoryDatabase : RoomDatabase() {

    abstract fun itemDao(): ItemDao

    //The companion object will allow access to the methods for creating or generating the database
    // and which will use the class name as a qualifier.
    // The Instance variable will hold a reference to the database.
    // This way, only one instance of the database is open at a time.
    // the Instance var is Volatile so its value will be always up to date and identical for all execution threads.
    // All writing or reading will be from main memory (never put in cache).

    companion object {
        @Volatile
        private var Instance: InventoryDatabase? = null

        // Intance is synchronised for ensuring that only one thread of execution at a time can access it.
        // don't want to generate multiple instances of the database.
        //The `fallbackToDestructiveMigration()` parameter allows the database to be recreated in the event of a version change,
        // instead of throwing an exception (⚠ only useful in development).
        //.also for keep a reference to the newly created database.

        fun getDatabase(context: Context): InventoryDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, InventoryDatabase::class.java, "item_database")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { Instance = it }
            }
        }
    }

}