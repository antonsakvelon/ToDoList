package com.akvelon.domain.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.akvelon.domain.dao.ToDoDao
import com.akvelon.domain.entities.ToDo
import com.akvelon.domain.utils.DateConverter

@Database(entities = [ToDo::class], version = 1)
@TypeConverters(DateConverter::class)
abstract class ToDoDatabase : RoomDatabase() {
    abstract fun toDoDao(): ToDoDao

    companion object {
        const val DB_NAME = "TODO_DB"
    }
}