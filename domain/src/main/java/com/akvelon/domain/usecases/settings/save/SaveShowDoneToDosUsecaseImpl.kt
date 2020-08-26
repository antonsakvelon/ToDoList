package com.akvelon.domain.usecases.settings.save

import com.akvelon.domain.repositories.SettingsRepository

class SaveShowDoneToDosUsecaseImpl(private val repository: SettingsRepository) : SaveShowDoneToDosUsecase {
    override suspend fun execute(params: SaveShowDoneToDosUsecase.Params) {
        repository.saveShowDoneToDos(params.show)
    }
}