package com.akvelon.domain.dao

import androidx.room.*
import com.akvelon.domain.entities.ToDo

@Dao
interface ToDoDao {
    @Query("SELECT * FROM todo")
    suspend fun getAll(): List<ToDo>

    @Query("SELECT * from todo WHERE uid= :id")
    suspend fun getById(id: Int) : List<ToDo>

    @Insert
    suspend fun insert(toDo: ToDo)

    @Update
    suspend fun update(toDo: ToDo)

    @Delete
    suspend fun delete(toDo: ToDo)
}