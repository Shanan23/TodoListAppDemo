package com.nahsbyte.todolistappdemo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TodoViewModel : ViewModel() {
    private val todoRepository = TodoRepository()

    private val _todos = MutableLiveData<List<Todo>>()

    val todos: LiveData<List<Todo>> = _todos

    fun fetchTodos() {
        viewModelScope.launch {
            try {
                val response = todoRepository.getTodos()
                if (response.isSuccessful) {
                    _todos.value = response.body()?.todos ?: emptyList()
                } else {
                    // Handle error case
                    _todos.value = emptyList()
                }
            } catch (e: Exception) {
                // Handle exception
                _todos.value = emptyList()
            }
        }
    }

    fun addTodo(todo: String){
        viewModelScope.launch {
            try {
                val response = todoRepository.addTodo(todo)
                if (response.isSuccessful) {
                    fetchTodos() // Refresh the list after adding
                } else {
                    // Handle error case
                    Log.e("TodoViewModel", "Error adding todo: ${response.errorBody()?.string()}")
                }
            } catch (e: Exception) {
                // Handle exception
                Log.e("TodoViewModel", "Exception adding todo: ${e.message}")
            }
        }
    }

    fun updateTodo(id: Int, todo: String, completed: Boolean) {
        viewModelScope.launch {
            try {
                val response = todoRepository.updateTodo(id, todo, completed)
                if (response.isSuccessful) {
                    fetchTodos() // Refresh the list after updating
                } else {
                    // Handle error case
                    Log.e("TodoViewModel", "Error updating todo: ${response.errorBody()?.string()}")
                }
            } catch (e: Exception) {
                // Handle exception
                Log.e("TodoViewModel", "Exception updating todo: ${e.message}")
            }
        }
    }

    fun deleteTodo(id: Int) {
        viewModelScope.launch {
            try {
                val response = todoRepository.deleteTodo(id)
                if (response.isSuccessful) {
                    fetchTodos() // Refresh the list after deleting
                } else {
                    // Handle error case
                    Log.e("TodoViewModel", "Error deleting todo: ${response.errorBody()?.string()}")
                }
            } catch (e: Exception) {
                // Handle exception
                Log.e("TodoViewModel", "Exception deleting todo: ${e.message}")
            }
        }
    }
}