package com.example.lesson_2homework3.models

import java.io.FileDescriptor
import java.io.Serializable

data class Todo(var name:String,var descriptor:String,var deggre:IdClassImage,var creatDate:String,
                var dedline:String,var category:String="Open"):Serializable