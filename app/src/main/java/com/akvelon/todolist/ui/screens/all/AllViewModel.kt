package com.akvelon.todolist.ui.screens.all

import androidx.lifecycle.MutableLiveData
import com.akvelon.domain.entities.ToDo
import com.akvelon.domain.usecases.todo.delete.DeleteToDoUsecase
import com.akvelon.domain.usecases.todo.getall.GetAllToDosUsecase
import com.akvelon.domain.usecases.todo.update.UpdateToDoUsecase
import com.akvelon.todolist.ui.base.BaseViewModel

class AllViewModel(
    private val getAllToDosUsecase: GetAllToDosUsecase,
    private val updateToDoUsecase: UpdateToDoUsecase,
    private val deleteToDoUsecase: DeleteToDoUsecase
) : BaseViewModel() {
    val toDos = MutableLiveData<List<ToDo>>()

    fun loadToDos() {
        launchExplicitly {
            toDos.value = getAllToDosUsecase.execute(GetAllToDosUsecase.Params())
        }
    }

    fun updateToDo(toDo: ToDo) {
        launchExplicitly {
            updateToDoUsecase.execute(UpdateToDoUsecase.Params(toDo))
        }
        loadToDos()
    }

    fun deleteToDo(toDo: ToDo) {
        launchExplicitly {
            deleteToDoUsecase.execute(DeleteToDoUsecase.Params(toDo))
        }
        loadToDos()
    }
}