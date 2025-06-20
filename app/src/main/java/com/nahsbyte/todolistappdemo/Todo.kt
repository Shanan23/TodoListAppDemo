package com.nahsbyte.todolistappdemo

data class Todo(
    val id: Int,
    val todo: String,
    val userId: Int,
    val completed: Boolean
)
