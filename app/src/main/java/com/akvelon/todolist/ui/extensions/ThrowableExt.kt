package com.akvelon.todolist.ui.extensions

import android.content.res.Resources
import com.akvelon.domain.exceptions.EmptyToDoNameException
import com.akvelon.todolist.R

fun Throwable.toMessage(resources: Resources): String {
    return when (this) {
        is EmptyToDoNameException -> resources.getString(R.string.empty_todo_error)
        else -> resources.getString(R.string.unexpected_error)
    }
}