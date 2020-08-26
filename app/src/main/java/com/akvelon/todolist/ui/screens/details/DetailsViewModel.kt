package com.akvelon.todolist.ui.screens.details

import androidx.lifecycle.MutableLiveData
import com.akvelon.domain.entities.ToDo
import com.akvelon.domain.exceptions.EmptyToDoNameException
import com.akvelon.domain.usecases.todo.getbyid.GetToDoByIdUsecase
import com.akvelon.domain.usecases.todo.insert.InsertToDoUsecase
import com.akvelon.domain.usecases.todo.update.UpdateToDoUsecase
import com.akvelon.todolist.ui.base.BaseViewModel
import java.util.*

class DetailsViewModel(
    private val getToDoByIdUsecase: GetToDoByIdUsecase,
    private val insertToDoUsecase: InsertToDoUsecase,
    private val updateToDoUsecase: UpdateToDoUsecase,
    private val toDoId: String? = null
) : BaseViewModel() {
    val toDo = MutableLiveData<ToDo?>(null)
    val saved = MutableLiveData(false)

    fun fetchToDo(id: Int) {
        launchExplicitly {
            toDo.value = getToDoByIdUsecase.execute(GetToDoByIdUsecase.Params(id))
        }
    }

    fun saveToDo(name: String, description: String, date: Date) {
        if (name.isBlank()) {
            error.value = EmptyToDoNameException()
        } else {
            launchExplicitly {
                val currentToDo = toDo.value
                if (currentToDo == null) {
                    val newToDo = ToDo(
                        name = name,
                        description = description,
                        date = date
                    )
                    insertToDoUsecase.execute(InsertToDoUsecase.Params(newToDo))
                } else {
                    val updatedToDo = currentToDo.apply {
                        this.name = name
                        this.description = description
                        this.date = date
                    }
                    updateToDoUsecase.execute(UpdateToDoUsecase.Params(updatedToDo))
                }
            }
            saved.value = true
        }
    }
}