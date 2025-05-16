package com.example.todoapptrail.data.repository

import android.content.Context
import androidx.room.Room
import com.example.todoapptrail.data.local.AppDatabase
import com.example.todoapptrail.data.remote.RetrofitInstance
import com.example.todoapptrail.model.Todo
import kotlinx.coroutines.flow.Flow

class TodoRepository(context: Context) {
    private val db = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        "todo_db"
    ).build()

    private val api = RetrofitInstance.api

    suspend fun refreshTodos() {
        try {
            val response = api.getTodos()
            if (response.isSuccessful) {
                response.body()?.let { todos ->
                    db.todoDao().insertAll(todos)
                }
            }
        } catch (e: Exception) {
            // Error handled by showing cached data
        }
    }

    fun getAllTodos(): Flow<List<Todo>> = db.todoDao().getAllTodos()
    fun getTodoById(id: Int): Flow<Todo> = db.todoDao().getTodoById(id)
}