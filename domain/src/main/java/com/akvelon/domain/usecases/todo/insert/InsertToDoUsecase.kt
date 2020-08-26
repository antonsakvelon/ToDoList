package com.akvelon.domain.usecases.todo.insert

import com.akvelon.domain.entities.ToDo
import com.akvelon.domain.usecases.base.SuspendUsecase

interface InsertToDoUsecase : SuspendUsecase<InsertToDoUsecase.Params, Unit> {
    class Params(val toDo: ToDo)
}