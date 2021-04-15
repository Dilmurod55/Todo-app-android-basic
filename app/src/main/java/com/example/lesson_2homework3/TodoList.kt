package com.example.lesson_2homework3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lesson_2homework3.adapters.ExoandableAdapter
import com.example.lesson_2homework3.models.Todo
import com.example.lesson_2homework3.sharedpreferens.MysheredPreferens
import kotlinx.android.synthetic.main.activity_todo_list.*
import kotlinx.android.synthetic.main.toolbar.*

class TodoList : AppCompatActivity() {
    lateinit var list: ArrayList<String>
    lateinit var map: HashMap<String, List<Todo>>
    var position = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo_list)
        toolbar.setTitle("")
        toolbartext.setText("To do list")
        loadAdapter()
        expandable_list_view.setAdapter(ExoandableAdapter(list, map))
//        expandable_list_view.divider = null

//        expandable_list_view.setOnGroupExpandListener {
//            if (position!=-1 && position!=it){
//                expandable_list_view.collapseGroup(position)
//            }
//            position=it
//        }

        expandable_list_view.setOnChildClickListener { parent, v, groupPosition, childPosition, id ->
            var intent = Intent(this,NamesofDoes::class.java)
            var todoName = map[list[groupPosition]]!![childPosition].name
            var alltodo = MysheredPreferens(this).getTodo()
            var todo = alltodo.find { it.name==todoName }
            intent.putExtra("TODO_SELECTED",todo)
            startActivity(intent)
//            expandable_list_view.collapseGroup(groupPosition)
            finish()
            true
        }
    }
        private fun loadAdapter() {
            list = arrayListOf("Open", "Development","Uploading","Reject","Closed")
            var allTodos = MysheredPreferens(this@TodoList).getTodo()
            map = HashMap()
            if (allTodos.isEmpty()){
                map["Open"] = listOf()
                map["Development"] = listOf()
                map["Uploading"] = listOf()
                map["Reject"] = listOf()
                map["Closed"] = listOf()
            }else {
                map["Open"] = allTodos.filter { it.category == "Open" }
                map["Development"] = allTodos.filter { it.category == "Development" }
                map["Uploading"] = allTodos.filter { it.category == "Uploading" }
                map["Reject"] = allTodos.filter { it.category == "Reject" }
                map["Closed"] = allTodos.filter { it.category == "Closed" }
            }

        }
    override fun onBackPressed() {
        var intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }
    }

