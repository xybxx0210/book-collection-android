package com.example.bookcollection

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var etBookName: EditText
    private lateinit var etAuthor: EditText
    private lateinit var btnAdd: Button
    private lateinit var lvBookList: ListView

    private val bookList = arrayListOf<String>()
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etBookName = findViewById(R.id.etBookName)
        etAuthor = findViewById(R.id.etAuthor)
        btnAdd = findViewById(R.id.btnAdd)
        lvBookList = findViewById(R.id.lvBookList)

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, bookList)
        lvBookList.adapter = adapter

        btnAdd.setOnClickListener {
            val name = etBookName.text.toString().trim()
            val author = etAuthor.text.toString().trim()
            if (name.isNotEmpty() && author.isNotEmpty()) {
                bookList.add("《$name》 —— $author")
                adapter.notifyDataSetChanged()
                etBookName.text.clear()
                etAuthor.text.clear()
            }
        }
    }
}
