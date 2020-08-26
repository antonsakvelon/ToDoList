package com.akvelon.domain.repositories

interface SettingsRepository {
    suspend fun saveShowDoneToDos(show: Boolean)
    suspend fun loadShowDoneToDos(): Boolean
}