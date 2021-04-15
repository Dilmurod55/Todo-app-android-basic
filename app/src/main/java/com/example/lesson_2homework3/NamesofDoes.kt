package com.example.lesson_2homework3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import com.example.lesson_2homework3.models.Todo
import com.example.lesson_2homework3.sharedpreferens.MysheredPreferens
//import com.example.todoapp.models.Todo
//import com.example.todoapp.sharedpreferens.MysheredPreferens
import kotlinx.android.synthetic.main.activity_namesof_does.*

class NamesofDoes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_namesof_does)
        var selectedTodo = intent.getSerializableExtra("TODO_SELECTED") as Todo
        var selectedCt=0
        if (selectedTodo.category!="Open"){
            when(selectedTodo.category){
                "Development"->selectedCt=1
                "Uploading"->selectedCt=2
                "Reject"->selectedCt=3
                "Closed"->selectedCt=4
            }
        }
        var defaultSelected = radio_group.getChildAt(selectedCt) as RadioButton
        defaultSelected.isChecked=true

        name_todo.text=selectedTodo.name
        description.text=selectedTodo.descriptor
        img.setImageResource(selectedTodo.deggre.ImgUrl)
        text_level.text = selectedTodo.deggre.ImgName
        text_creat.text = selectedTodo.creatDate
        text_dedline.text = selectedTodo.dedline

        ok_btn.setOnClickListener {
            var selectedCategory = radio_group.checkedRadioButtonId
            var selectedName = findViewById<RadioButton>(selectedCategory).text
            var str = MysheredPreferens(this).getTodo()
            MysheredPreferens(this).removeTodo(selectedTodo.name)
            selectedTodo.category = "$selectedName"
            MysheredPreferens(this).addTodo(selectedTodo)

            var intent = Intent(this,TodoList::class.java)
            startActivity(intent)
        }
    }
    override fun onBackPressed() {
        var intent = Intent(this,TodoList::class.java)
        startActivity(intent)
    }



}