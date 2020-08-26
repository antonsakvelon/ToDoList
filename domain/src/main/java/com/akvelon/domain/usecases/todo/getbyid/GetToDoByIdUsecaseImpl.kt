package com.akvelon.domain.usecases.todo.getbyid

import com.akvelon.domain.entities.ToDo
import com.akvelon.domain.repositories.ToDoRepository

class GetToDoByIdUsecaseImpl(private val repository: ToDoRepository): GetToDoByIdUsecase {
    override suspend fun execute(params: GetToDoByIdUsecase.Params): ToDo = repository.getById(params.id)
}