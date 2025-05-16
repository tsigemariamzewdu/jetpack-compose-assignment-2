package com.example.todoapptrail.data.remote

import com.example.todoapptrail.model.Todo
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("todos")
    suspend fun getTodos(): Response<List<Todo>>
}