package com.akvelon.domain.usecases.todo.getall

import com.akvelon.domain.entities.ToDo
import com.akvelon.domain.repositories.ToDoRepository

class GetAllToDosUsecaseImpl(private val toDoRepository: ToDoRepository) : GetAllToDosUsecase {
    override suspend fun execute(params: GetAllToDosUsecase.Params): List<ToDo> = toDoRepository.getAll()
}