package com.example.todoapptrail.ui.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapptrail.data.repository.TodoRepository
import com.example.todoapptrail.model.Todo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoDetailViewModel @Inject constructor(
    private val repository: TodoRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _todo = MutableStateFlow<Todo?>(null)
    val todo: StateFlow<Todo?> = _todo

    init {
        val todoId = savedStateHandle.get<Int>("todoId") ?: 0
        viewModelScope.launch {
            repository.getTodoById(todoId).collect { todo ->
                _todo.value = todo
            }
        }
    }
}