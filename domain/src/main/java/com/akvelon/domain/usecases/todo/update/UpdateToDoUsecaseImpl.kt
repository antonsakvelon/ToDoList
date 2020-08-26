package com.akvelon.domain.usecases.todo.update

import com.akvelon.domain.repositories.ToDoRepository

class UpdateToDoUsecaseImpl(private val repository: ToDoRepository) : UpdateToDoUsecase {
    override suspend fun execute(params: UpdateToDoUsecase.Params) {
        repository.update(params.toDo)
    }
}