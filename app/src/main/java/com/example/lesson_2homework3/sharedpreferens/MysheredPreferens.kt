package com.example.lesson_2homework3.sharedpreferens

import android.content.Context
import com.example.lesson_2homework3.models.Todo

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MysheredPreferens(private var context: Context) {
    private val gson = Gson()
    private val sharedPreferences = context.getSharedPreferences("TODO_SHP",Context.MODE_PRIVATE)

    fun getTodo():ArrayList<Todo>{
     var todojson = sharedPreferences.getString("TODO_JSON","")
        return if (todojson!=""){
            var type = object:TypeToken<ArrayList<Todo>>(){}.type
            gson.fromJson(todojson,type)
        }else arrayListOf()
    }

    fun addTodo(todo: Todo){
        var editor = sharedPreferences.edit()
        var todos=getTodo()
        todos.add(todo)
        var jsonTodos = gson.toJson(todos)
        editor.putString("TODO_JSON",jsonTodos)
        editor.apply()
    }

    fun removeTodo(todoName:String){
        var editor = sharedPreferences.edit()
        var todos=getTodo()
        var temp = arrayListOf<Todo>()
        for (i in todos) if (i.name==todoName) temp.add(i)
        todos.removeAll(temp)
        var todoJson = gson.toJson(todos)
        editor.remove("TODO_JSON")
        editor.putString("TODO_JSON",todoJson)
        editor.apply()
    }
}