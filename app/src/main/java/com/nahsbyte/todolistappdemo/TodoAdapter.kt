package com.nahsbyte.todolistappdemo

import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class TodoAdapter(
    private val onCheckedChange: (Todo, Boolean) -> Unit,
    private val onDelete: (Todo) -> Unit
) :
    ListAdapter<Todo, TodoAdapter.TodoViewHolder>(TodoDiffCallback()) {

    override fun onCreateViewHolder(parent: android.view.ViewGroup, viewType: Int): TodoViewHolder {
        val view = android.view.LayoutInflater.from(parent.context)
            .inflate(R.layout.item_todo, parent, false)
        return TodoViewHolder(view)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val todo = getItem(position)
        holder.bind(todo)
    }

    inner class TodoViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        private val checkBox: CheckBox = itemView.findViewById(R.id.checkBox)
        private val textView: TextView = itemView.findViewById(R.id.todoText)
        private val deleteButton: ImageButton = itemView.findViewById(R.id.btnDelete)

        fun bind(todo: Todo) {

            textView.text = todo.todo

            checkBox.isChecked = todo.completed
            checkBox.setOnCheckedChangeListener { _, isChecked ->
                onCheckedChange(todo, isChecked)
            }

            deleteButton.setOnClickListener {
                onDelete(todo)
            }
        }
    }


}