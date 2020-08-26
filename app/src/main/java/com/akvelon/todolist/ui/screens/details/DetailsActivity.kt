package com.akvelon.todolist.ui.screens.details

import android.content.Context
import android.content.Intent
import android.icu.util.Calendar
import android.os.Bundle
import com.akvelon.todolist.R
import com.akvelon.todolist.ToDoListApp
import com.akvelon.todolist.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : BaseActivity<DetailsViewModel>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        buttonSave.setOnClickListener {
            val calendar = Calendar.getInstance()
            calendar.set(pickerDate.year, pickerDate.month, pickerDate.dayOfMonth)
            vm.saveToDo(
                editName.text.toString(),
                editDescription.text.toString(),
                calendar.time
            )
        }
        buttonCancel.setOnClickListener { finish() }
    }

    override fun onStart() {
        super.onStart()
        if (intent.hasExtra(TODO_ID_KEY)) {
            vm.fetchToDo(intent.getIntExtra(TODO_ID_KEY, -1))
        }
    }

    override fun createViewModel() = ToDoListApp.instance.locator.createDetailsViewModel()

    override fun bindViewModel() {
        super.bindViewModel()
        vm.toDo.observe(this, {
            it?.let {
                editName.setText(it.name)
                if (it.description.isNotEmpty()) editDescription.setText(it.description)

                val calendar = Calendar.getInstance()
                calendar.time = it.date
                pickerDate.init(
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH),
                    { _, _, _, _ -> }
                )
            }
        })
        vm.saved.observe(this) { if (it) finish() }
    }

    companion object {
        private const val TODO_ID_KEY = "ID_KEY"
        fun getIntent(context: Context?, id: Int? = null): Intent {
            return Intent(context, DetailsActivity::class.java).apply {
                id?.let { putExtra(TODO_ID_KEY, it) }
            }
        }
    }
}