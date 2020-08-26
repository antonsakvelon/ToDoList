package com.akvelon.domain.usecases.todo.getbyid

import com.akvelon.domain.entities.ToDo
import com.akvelon.domain.usecases.base.SuspendUsecase

interface GetToDoByIdUsecase : SuspendUsecase<GetToDoByIdUsecase.Params, ToDo> {
    class Params(val id: Int)
}