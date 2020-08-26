package com.akvelon.domain.usecases.todo.delete

import com.akvelon.domain.entities.ToDo
import com.akvelon.domain.usecases.base.SuspendUsecase

interface DeleteToDoUsecase : SuspendUsecase<DeleteToDoUsecase.Params, Unit> {
    class Params(val toDo: ToDo)
}