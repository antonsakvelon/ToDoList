package com.akvelon.todolist.ui.screens.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.akvelon.todolist.R
import com.akvelon.todolist.ToDoListApp
import com.akvelon.todolist.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_settings.*

class SettingsFragment : BaseFragment<SettingsViewModel>() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showSwitch.setOnCheckedChangeListener { _, isChecked ->
            vm.saveShowDoneToDos(isChecked)
        }
    }

    override fun onResume() {
        super.onResume()
        vm.loadShowDoneToDos()
    }

    override fun createViewModel() = ToDoListApp.instance.locator.createSettingsViewModel()

    override fun bindViewModel() {
        super.bindViewModel()
        vm.showDoneToDos.observe(this, { showSwitch.isChecked = it })
    }
}