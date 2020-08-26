package com.akvelon.todolist.ui.screens.settings

import androidx.lifecycle.MutableLiveData
import com.akvelon.domain.usecases.settings.load.LoadShowDoneToDosUsecase
import com.akvelon.domain.usecases.settings.save.SaveShowDoneToDosUsecase
import com.akvelon.todolist.ui.base.BaseViewModel

class SettingsViewModel(
    private val loadShowDoneToDosUsecase: LoadShowDoneToDosUsecase,
    private val saveShowDoneToDosUsecase: SaveShowDoneToDosUsecase
) : BaseViewModel() {
    val showDoneToDos = MutableLiveData<Boolean>()

    fun loadShowDoneToDos() {
        launchExplicitly {
            showDoneToDos.value = loadShowDoneToDosUsecase.execute(LoadShowDoneToDosUsecase.Params())
        }
    }

    fun saveShowDoneToDos(show: Boolean) {
        showDoneToDos.value = show
        launchExplicitly {
            saveShowDoneToDosUsecase.execute(SaveShowDoneToDosUsecase.Params(show))
        }
    }
}