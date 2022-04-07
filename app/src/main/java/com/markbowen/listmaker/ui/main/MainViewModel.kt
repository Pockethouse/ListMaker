package com.markbowen.listmaker.ui.main

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel

class MainViewModel(private val sharedPreferences: SharedPreferences) : ViewModel() {

    lateinit var onListAdded: (() -> Unit)

    val lists: MutableList<TaskList> by lazy {
        retrieveLists()
    }
    private  fun retrieveLists(): MutableList<TaskList> {

        val sharedPreferencesContents = sharedPreferences.all
        val taskLists = ArrayList<TaskList>()

        for (taskList in sharedPreferencesContents){
            val itemsHashSet = ArrayList(taskList.value as HashSet<String>)
            val list = TaskList(taskList.key, itemsHashSet)
            taskLists.add(list)
        }
        return taskLists
    }
}