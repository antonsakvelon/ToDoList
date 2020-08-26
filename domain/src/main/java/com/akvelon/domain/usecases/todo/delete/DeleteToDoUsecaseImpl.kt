package com.akvelon.domain.usecases.todo.delete

import com.akvelon.domain.repositories.ToDoRepository

class DeleteToDoUsecaseImpl(private val repository: ToDoRepository): DeleteToDoUsecase {
    override suspend fun execute(params: DeleteToDoUsecase.Params) {
        repository.delete(params.toDo)
    }
}