package com.example.kotlintodo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var todoAdapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views
        val rvTodoItems = findViewById<RecyclerView>(R.id.rvTodoItems)
        val btnAddItem = findViewById<Button>(R.id.btnAddItem)
        val btnDeleteDoneTodos = findViewById<Button>(R.id.btnDeleteItem)
        val etTodoTitle = findViewById<EditText>(R.id.etTodoTitle)

        todoAdapter = TodoAdapter(mutableListOf())
        rvTodoItems.adapter = todoAdapter
        rvTodoItems.layoutManager = LinearLayoutManager(this)

        btnAddItem.setOnClickListener {
            val todoItem = etTodoTitle.text.toString()
            if (todoItem.isNotEmpty()) {
                val todo = Todo(todoItem, false)
                todoAdapter.addTodo(todo)
                etTodoTitle.text.clear()
            }
        }

        btnDeleteDoneTodos.setOnClickListener {
            todoAdapter.deleteDoneTodos()
        }
    }
}
