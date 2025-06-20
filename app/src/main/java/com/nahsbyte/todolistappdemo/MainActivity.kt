package com.nahsbyte.todolistappdemo

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: TodoViewModel
    private lateinit var adapter: TodoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this)[TodoViewModel::class.java]

        adapter = TodoAdapter(
            onCheckedChange = { todo, isChecked ->
                viewModel.updateTodo(todo.id, todo.todo, isChecked)
            },
            onDelete = { todo ->
                viewModel.deleteTodo(todo.id)
            }
        )

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        viewModel.todos.observe(this) { todos ->
            adapter.submitList(todos)
        }

        viewModel.fetchTodos()

        val addButton = findViewById<Button>(R.id.addButton)
        val editTextTodo = findViewById<android.widget.EditText>(R.id.editTextTodo)

        addButton.setOnClickListener {
            val todoText = editTextTodo.text.toString()
            if (todoText.isNotBlank()) {
                viewModel.addTodo(todoText)
                editTextTodo.text.clear() // Clear the input field after adding
            }
        }



    }
}