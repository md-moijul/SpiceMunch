package com.example.spice_munch

import android.content.Context
import androidx.room.Room
import com.example.spice_munch.data.database.AppDatabase


object DatabaseBuilder {
    private var instance: AppDatabase? = null

    fun getDatabase(context: Context): AppDatabase {
        if (instance == null) {
            synchronized(AppDatabase::class) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java, "yourapp_database"
                ).build()
            }
        }
        return instance!!
    }
}