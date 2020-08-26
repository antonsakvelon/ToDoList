package com.akvelon.domain.usecases.todo.update

import com.akvelon.domain.entities.ToDo
import com.akvelon.domain.usecases.base.SuspendUsecase

interface UpdateToDoUsecase : SuspendUsecase<UpdateToDoUsecase.Params, Unit> {
    class Params(val toDo: ToDo)
}