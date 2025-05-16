package com.example.todoapptrail.di

import android.content.Context
import com.example.todoapptrail.data.repository.TodoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideTodoRepository(@ApplicationContext context: Context): TodoRepository {
        return TodoRepository(context)
    }
}