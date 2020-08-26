package com.akvelon.todolist.ui.screens.today

import androidx.lifecycle.MutableLiveData
import com.akvelon.domain.entities.ToDo
import com.akvelon.domain.usecases.settings.load.LoadShowDoneToDosUsecase
import com.akvelon.domain.usecases.todo.delete.DeleteToDoUsecase
import com.akvelon.domain.usecases.todo.getallbydate.GetAllToDosByDateUsecase
import com.akvelon.domain.usecases.todo.update.UpdateToDoUsecase
import com.akvelon.todolist.ui.base.BaseViewModel
import java.util.*

class TodayViewModel(
    private val getAllToDosByDateUsecase: GetAllToDosByDateUsecase,
    private val loadShowDoneToDosUsecase: LoadShowDoneToDosUsecase,
    private val updateToDoUsecase: UpdateToDoUsecase,
    private val deleteToDoUsecase: DeleteToDoUsecase
) : BaseViewModel() {
    val toDos = MutableLiveData<List<ToDo>>()

    fun loadTodayToDos() {
        launchExplicitly {
            val showDoneToDos = loadShowDoneToDosUsecase.execute(LoadShowDoneToDosUsecase.Params())
            val todayToDos = getAllToDosByDateUsecase.execute(GetAllToDosByDateUsecase.Params(Date()))
            toDos.value = if (showDoneToDos.not()) {
                todayToDos.filter { it.done.not() }
            } else todayToDos
        }
    }

    fun updateToDo(toDo: ToDo) {
        launchExplicitly {
            updateToDoUsecase.execute(UpdateToDoUsecase.Params(toDo))
        }
        loadTodayToDos()
    }

    fun deleteToDo(toDo: ToDo) {
        launchExplicitly {
            deleteToDoUsecase.execute(DeleteToDoUsecase.Params(toDo))
        }
        loadTodayToDos()
    }
}