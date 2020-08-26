package com.akvelon.domain.usecases.settings.load

import com.akvelon.domain.repositories.SettingsRepository

class LoadShowDoneToDosUsecaseImpl(private val repository: SettingsRepository) : LoadShowDoneToDosUsecase {
    override suspend fun execute(params: LoadShowDoneToDosUsecase.Params): Boolean = repository.loadShowDoneToDos()
}