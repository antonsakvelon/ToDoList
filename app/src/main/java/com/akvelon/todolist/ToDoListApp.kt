package com.akvelon.todolist

import android.app.Application

class ToDoListApp : Application() {
    val locator: ServiceLocator by lazy { ServiceLocator(this) }

    companion object {
        lateinit var instance: ToDoListApp
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}