package com.akvelon.todolist

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.akvelon.data.repositories.LocalToDoRepositoryImpl
import com.akvelon.data.repositories.PreferencesSettingsRepositoryImpl
import com.akvelon.data.repositories.PreferencesSettingsRepositoryImpl.Companion.SETTINGS_PREFERENCES_NAME
import com.akvelon.domain.database.ToDoDatabase
import com.akvelon.domain.repositories.ToDoRepository
import com.akvelon.domain.usecases.settings.load.LoadShowDoneToDosUsecase
import com.akvelon.domain.usecases.settings.load.LoadShowDoneToDosUsecaseImpl
import com.akvelon.domain.usecases.settings.save.SaveShowDoneToDosUsecase
import com.akvelon.domain.usecases.settings.save.SaveShowDoneToDosUsecaseImpl
import com.akvelon.domain.usecases.todo.delete.DeleteToDoUsecase
import com.akvelon.domain.usecases.todo.delete.DeleteToDoUsecaseImpl
import com.akvelon.domain.usecases.todo.getall.GetAllToDosUsecase
import com.akvelon.domain.usecases.todo.getall.GetAllToDosUsecaseImpl
import com.akvelon.domain.usecases.todo.getallbydate.GetAllToDosByDateUsecase
import com.akvelon.domain.usecases.todo.getallbydate.GetAllToDosByDateUsecaseImpl
import com.akvelon.domain.usecases.todo.getbyid.GetToDoByIdUsecase
import com.akvelon.domain.usecases.todo.getbyid.GetToDoByIdUsecaseImpl
import com.akvelon.domain.usecases.todo.insert.InsertToDoUsecase
import com.akvelon.domain.usecases.todo.insert.InsertToDoUsecaseImpl
import com.akvelon.domain.usecases.todo.update.UpdateToDoUsecase
import com.akvelon.domain.usecases.todo.update.UpdateToDoUsecaseImpl
import com.akvelon.todolist.ui.screens.all.AllViewModel
import com.akvelon.todolist.ui.screens.details.DetailsViewModel
import com.akvelon.todolist.ui.screens.settings.SettingsViewModel
import com.akvelon.todolist.ui.screens.today.TodayViewModel

class ServiceLocator(app: ToDoListApp) {
    private val appContext = app.applicationContext

    // Repositories

    private val toDoRepository : ToDoRepository by lazy {
        val toDoDatabase = Room.databaseBuilder(
            appContext,
            ToDoDatabase::class.java,
            ToDoDatabase.DB_NAME
        ).build()
        LocalToDoRepositoryImpl(toDoDatabase.toDoDao())
    }

    private val settingsRepository by lazy {
        PreferencesSettingsRepositoryImpl(createSharedPreferences(SETTINGS_PREFERENCES_NAME))
    }

    // Common functions

    private fun createSharedPreferences(name: String): SharedPreferences {
        return appContext.getSharedPreferences(
            name,
            Context.MODE_PRIVATE
        )
    }

    // Usecases

    private fun createGetAllToDosByDateUsecase(): GetAllToDosByDateUsecase {
        return GetAllToDosByDateUsecaseImpl(toDoRepository)
    }

    private fun createGetAllToDosUsecase(): GetAllToDosUsecase {
        return GetAllToDosUsecaseImpl(toDoRepository)
    }

    private fun createGetToDoByIdUsecase(): GetToDoByIdUsecase {
        return GetToDoByIdUsecaseImpl(toDoRepository)
    }

    private fun createInsertToDoUsecase(): InsertToDoUsecase {
        return InsertToDoUsecaseImpl(toDoRepository)
    }

    private fun createUpdateToDoUsecase(): UpdateToDoUsecase {
        return UpdateToDoUsecaseImpl(toDoRepository)
    }

    private fun createDeleteToDoUsecase(): DeleteToDoUsecase {
        return DeleteToDoUsecaseImpl(toDoRepository)
    }

    private fun createLoadShowDoneToDosUsecase(): LoadShowDoneToDosUsecase {
        return LoadShowDoneToDosUsecaseImpl(settingsRepository)
    }

    private fun createSaveShowDoneToDosUsecase(): SaveShowDoneToDosUsecase {
        return SaveShowDoneToDosUsecaseImpl(settingsRepository)
    }

    // ViewModels

    fun createTodayViewModel(): TodayViewModel {
        return TodayViewModel(
            createGetAllToDosByDateUsecase(),
            createLoadShowDoneToDosUsecase(),
            createUpdateToDoUsecase(),
            createDeleteToDoUsecase()
        )
    }

    fun createAllViewModel(): AllViewModel {
        return AllViewModel(
            createGetAllToDosUsecase(),
            createUpdateToDoUsecase(),
            createDeleteToDoUsecase()
        )
    }

    fun createSettingsViewModel(): SettingsViewModel {
        return SettingsViewModel(
            createLoadShowDoneToDosUsecase(),
            createSaveShowDoneToDosUsecase()
        )
    }

    fun createDetailsViewModel() : DetailsViewModel {
        return DetailsViewModel(
            createGetToDoByIdUsecase(),
            createInsertToDoUsecase(),
            createUpdateToDoUsecase()
        )
    }
}