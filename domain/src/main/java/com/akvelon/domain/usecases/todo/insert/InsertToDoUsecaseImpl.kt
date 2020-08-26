package com.akvelon.domain.usecases.todo.insert

import com.akvelon.domain.repositories.ToDoRepository

class InsertToDoUsecaseImpl(private val repository: ToDoRepository) : InsertToDoUsecase {
    override suspend fun execute(params: InsertToDoUsecase.Params) {
        repository.insert(params.toDo)
    }
}