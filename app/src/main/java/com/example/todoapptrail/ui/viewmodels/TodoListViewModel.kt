package com.example.todoapptrail.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapptrail.data.repository.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoListViewModel @Inject constructor(
    private val repository: TodoRepository
) : ViewModel() {
    val todos = repository.getAllTodos()

    init {
        refreshData()
    }

    fun refreshData() {
        viewModelScope.launch {
            repository.refreshTodos()
        }
    }
}