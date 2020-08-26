package com.akvelon.domain.repositories

import com.akvelon.domain.entities.ToDo
import java.util.*

interface ToDoRepository {
    suspend fun getAll(): List<ToDo>
    suspend fun getAllByDate(date: Date): List<ToDo>
    suspend fun getById(id: Int): ToDo
    suspend fun insert(toDo: ToDo)
    suspend fun update(toDo: ToDo)
    suspend fun delete(toDo: ToDo)
}