package com.akvelon.todolist.ui.common

import android.text.format.DateFormat
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.akvelon.domain.entities.ToDo
import com.akvelon.todolist.R
import com.akvelon.todolist.ui.base.adapter.BaseViewHolder
import com.akvelon.todolist.ui.extensions.inflate
import kotlinx.android.synthetic.main.item_todo.view.*

class ToDoViewHolder(
    parent: ViewGroup,
    private val onDoneToggleClicked: (ToDo) -> Unit,
    private val onTextClicked: (ToDo) -> Unit,
    private val onDeleteClicked: (ToDo) -> Unit
) : BaseViewHolder<ToDo>(parent.inflate(R.layout.item_todo)) {

    override fun updateUI(item: ToDo) {
        with(root) {
            val doneDrawable = if (item.done) R.drawable.ic_done else R.drawable.ic_not_done
            toggleDone.setImageDrawable(ContextCompat.getDrawable(context, doneDrawable))
            textName.text = item.name
            textDate.text = DateFormat.getDateFormat(context).format(item.date)

            toggleDone.setOnClickListener { onDoneToggleClicked.invoke(item.apply { done = item.done.not()}) }
            layoutText.setOnClickListener { onTextClicked.invoke(item) }
            buttonDelete.setOnClickListener { onDeleteClicked.invoke(item) }
        }
    }
}