package com.example.lesson_2homework3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        card1.setOnClickListener {
            var intent = Intent(this,TodoList::class.java)
            startActivity(intent)
        }
        card2.setOnClickListener {
            var intent = Intent(this,Addtodo::class.java)
            startActivity(intent)
        }
    }
}