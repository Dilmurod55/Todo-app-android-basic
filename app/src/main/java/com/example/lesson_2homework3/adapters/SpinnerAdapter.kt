package com.example.lesson_2homework3.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.lesson_2homework3.R
import com.example.lesson_2homework3.models.IdClassImage

import kotlinx.android.synthetic.main.item_view1.view.*

class SpinnerAdapter(var list: List<IdClassImage>):BaseAdapter() {
    override fun getCount(): Int {
    return list.size
    }

    override fun getItem(position: Int): IdClassImage {
     return list[position]
    }

    override fun getItemId(position: Int): Long {
         return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
       var itemView:View
       if (convertView==null){
           itemView=LayoutInflater.from(parent?.context).inflate(R.layout.item_view1,parent,false)
       }else{
           itemView=convertView
       }
        itemView.image_view.setImageResource(list[position].ImgUrl)
        itemView.text_view.text=list[position].ImgName
        return itemView
    }
}