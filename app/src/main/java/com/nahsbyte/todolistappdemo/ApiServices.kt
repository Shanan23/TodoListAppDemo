package com.nahsbyte.todolistappdemo

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiServices {
    @GET("todos")
    suspend fun getTodos(): Response<TodoListResponse>

    @POST("todos/add")
    suspend fun addTodo(todo: AddTodoRequest): Response<Todo>

    @PUT("todos/{id}")
    suspend fun updateTodo(
        @Path("id") id: Int,
        @Body todo: UpdateTodoRequest
    ): Response<Todo>

    @DELETE("todos/{id}")
    suspend fun deleteTodo(
        @Path("id") id: Int
    ): Response<Unit>
}