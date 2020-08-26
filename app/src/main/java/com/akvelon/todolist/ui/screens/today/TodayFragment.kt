package com.akvelon.todolist.ui.screens.today

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.akvelon.todolist.R
import com.akvelon.todolist.ToDoListApp
import com.akvelon.todolist.ui.base.BaseFragment
import com.akvelon.todolist.ui.common.ToDoAdapter
import com.akvelon.todolist.ui.screens.details.DetailsActivity
import kotlinx.android.synthetic.main.fragment_all.*

class TodayFragment : BaseFragment<TodayViewModel>() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_today, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(recyclerToDos) {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            adapter = ToDoAdapter(
                vm::updateToDo,
                { startActivity(DetailsActivity.getIntent(context, it.uid)) },
                vm::deleteToDo
            )
            addItemDecoration(DividerItemDecoration(context, RecyclerView.VERTICAL))
        }
        buttonAdd.setOnClickListener { startActivity(DetailsActivity.getIntent(context)) }
    }

    override fun onResume() {
        super.onResume()
        vm.loadTodayToDos()
    }

    override fun createViewModel() = ToDoListApp.instance.locator.createTodayViewModel()

    override fun bindViewModel() {
        super.bindViewModel()
        vm.toDos.observe(this, {
            with(recyclerToDos.adapter as ToDoAdapter) {
                items.clear()
                items.addAll(it)
                notifyDataSetChanged()
            }
        })
    }
}