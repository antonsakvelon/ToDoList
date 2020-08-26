package com.akvelon.data.repositories

import android.content.SharedPreferences
import com.akvelon.data.extensions.saveBoolean
import com.akvelon.domain.repositories.SettingsRepository

class PreferencesSettingsRepositoryImpl(private val preferences: SharedPreferences) : SettingsRepository {
    override suspend fun saveShowDoneToDos(show: Boolean) {
        preferences.saveBoolean(SHOW_DONE_TODOS_KEY, show)
    }

    override suspend fun loadShowDoneToDos(): Boolean = preferences.getBoolean(SHOW_DONE_TODOS_KEY, true)

    companion object {
        const val SETTINGS_PREFERENCES_NAME = "settings_prefs"
        private const val SHOW_DONE_TODOS_KEY = "show_done_todos"
    }
}