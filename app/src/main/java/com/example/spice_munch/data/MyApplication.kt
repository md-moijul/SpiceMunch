package com.example.spice_munch.data

import android.app.Application
import androidx.room.Room
import com.example.spice_munch.data.database.AppDatabase

class MyApplication : Application() {
    lateinit var database: AppDatabase

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(this, AppDatabase::class.java, "spice_munch_db").build()
    }
}