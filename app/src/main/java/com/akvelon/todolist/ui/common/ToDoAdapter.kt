package com.akvelon.todolist.ui.common

import android.view.ViewGroup
import com.akvelon.domain.entities.ToDo
import com.akvelon.todolist.ui.base.adapter.BaseAdapter

class ToDoAdapter(
    private val onDoneToggleClicked: (ToDo) -> Unit,
    private val onTextClicked: (ToDo) -> Unit,
    private val onDeleteClicked: (ToDo) -> Unit
) : BaseAdapter<ToDo, ToDoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        return ToDoViewHolder(parent, onDoneToggleClicked, onTextClicked, onDeleteClicked)
    }
}