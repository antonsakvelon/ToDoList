package com.akvelon.domain.usecases.todo.getallbydate

import com.akvelon.domain.entities.ToDo
import com.akvelon.domain.usecases.base.SuspendUsecase
import java.util.*

interface GetAllToDosByDateUsecase: SuspendUsecase<GetAllToDosByDateUsecase.Params, List<ToDo>> {
    class Params(val date: Date)
}