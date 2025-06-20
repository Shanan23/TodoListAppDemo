package com.nahsbyte.todolistappdemo

class TodoRepository {
    private val api = RetrofitInstance.api

    suspend fun getTodos() = api.getTodos()

    suspend fun addTodo(todo: String) = api.addTodo(AddTodoRequest(todo))

    suspend fun updateTodo(id: Int, todo: String, completed: Boolean) =
        api.updateTodo(id, UpdateTodoRequest(completed))

    suspend fun deleteTodo(id: Int) = api.deleteTodo(id)
}