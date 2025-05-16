package com.example.todoapptrail.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todoapptrail.model.Todo

@Database(entities = [Todo::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun todoDao(): TodoDao
}