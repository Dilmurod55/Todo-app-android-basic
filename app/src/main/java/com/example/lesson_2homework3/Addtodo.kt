package com.example.lesson_2homework3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.lesson_2homework3.adapters.SpinnerAdapter
import com.example.lesson_2homework3.models.IdClassImage
import com.example.lesson_2homework3.models.Todo
import com.example.lesson_2homework3.sharedpreferens.MysheredPreferens
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_addtodo.*
import kotlinx.android.synthetic.main.activity_todo_list.*
import kotlinx.android.synthetic.main.toolbar.*

class Addtodo : AppCompatActivity() {
    lateinit var spinnerAdapter:SpinnerAdapter
    lateinit var listImg:ArrayList<IdClassImage>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addtodo)
        toolbar.setTitle("")
        toolbartext.setText("Add ToDo")
        listImg = arrayListOf(
                IdClassImage(R.drawable.ic_flag, "Urgent"),
                IdClassImage(R.drawable.ic_flag2, "High"),
                IdClassImage(R.drawable.ic_flag3, "Normal"),
                IdClassImage(R.drawable.ic_flag4, "Low"))
        spinnerAdapter = SpinnerAdapter(listImg)
        spinner_view.adapter = spinnerAdapter

        addButton.setOnClickListener {
            var name = edit1.text.toString()
            var description = edit2.text.toString()
            var degree = listImg[spinner_view.selectedItemPosition]
            var creat = edit4.text.toString()
            var dedline = edit5.text.toString()
            var allTodo = MysheredPreferens(this).getTodo()
            if (name!=""&& description!="" && creat!="" && dedline!="") {
                var nodeText = allTodo.find { it.name == name }
                if (nodeText == null) {
                    var todo = Todo(name, description, degree, creat, dedline)
                    MysheredPreferens(this).addTodo(todo)
                    finish()
                } else {
                    Toast.makeText(this, "Bu malumot allaqachon mavjud", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Iltimos Barcha bo`shjoylarni to`ldiring", Toast.LENGTH_SHORT).show()
            }
        }
    }
}