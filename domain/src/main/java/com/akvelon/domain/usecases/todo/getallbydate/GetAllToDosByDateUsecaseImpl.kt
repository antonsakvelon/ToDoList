package com.akvelon.domain.usecases.todo.getallbydate

import com.akvelon.domain.entities.ToDo
import com.akvelon.domain.repositories.ToDoRepository

class GetAllToDosByDateUsecaseImpl(private val repository: ToDoRepository) : GetAllToDosByDateUsecase {
    override suspend fun execute(params: GetAllToDosByDateUsecase.Params): List<ToDo> = repository.getAllByDate(params.date)
}