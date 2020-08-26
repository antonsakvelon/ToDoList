package com.akvelon.domain.usecases.todo.getall

import com.akvelon.domain.entities.ToDo
import com.akvelon.domain.usecases.base.SuspendUsecase

interface GetAllToDosUsecase : SuspendUsecase<GetAllToDosUsecase.Params, List<ToDo>> {
    class Params
}