package com.akvelon.data.repositories

import com.akvelon.domain.dao.ToDoDao
import com.akvelon.domain.entities.ToDo
import com.akvelon.domain.repositories.ToDoRepository
import java.util.*

class LocalToDoRepositoryImpl(private val dao: ToDoDao) : ToDoRepository {
    override suspend fun getAll(): List<ToDo> = dao.getAll()

    override suspend fun getAllByDate(date: Date): List<ToDo> {
        val calendar = Calendar.getInstance().apply { time = date }
        val searchYear = calendar.get(Calendar.YEAR)
        val searchMonth = calendar.get(Calendar.MONTH)
        val searchDay = calendar.get(Calendar.DAY_OF_MONTH)
        return dao.getAll().filter {
            calendar.time = it.date
            searchYear == calendar.get(Calendar.YEAR) &&
                    searchMonth == calendar.get(Calendar.MONTH) &&
                    searchDay == calendar.get(Calendar.DAY_OF_MONTH)
        }
    }

    override suspend fun getById(id: Int): ToDo = dao.getById(id).first()

    override suspend fun insert(toDo: ToDo) {
        dao.insert(toDo)
    }

    override suspend fun update(toDo: ToDo) {
        dao.update(toDo)
    }

    override suspend fun delete(toDo: ToDo) {
        dao.delete(toDo)
    }
}