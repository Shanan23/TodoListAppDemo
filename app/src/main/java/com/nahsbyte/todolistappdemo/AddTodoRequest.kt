package com.nahsbyte.todolistappdemo

import android.app.admin.TargetUser

data class AddTodoRequest(
    val todo: String,
    val completed: Boolean = false,
    val userId: Int = 1
)
