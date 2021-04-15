package com.example.lesson_2homework3.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import com.example.lesson_2homework3.R
import com.example.lesson_2homework3.models.Todo
import kotlinx.android.synthetic.main.child_item.view.*
import kotlinx.android.synthetic.main.group_item.view.*
import kotlinx.android.synthetic.main.item_view1.view.*

@Suppress("TYPE_INFERENCE_ONLY_INPUT_TYPES_WARNING")
class ExoandableAdapter(var list: List<String>, var map:HashMap<String,List<Todo>>):
        BaseExpandableListAdapter() {
    override fun getGroupCount(): Int {
        return list.size
    }
    override fun getChildrenCount(groupPosition: Int): Int {
        return map[list[groupPosition]]?.size!!
    }
    override fun getGroup(groupPosition: Int):String {
       return list[groupPosition]
    }

    override fun getChild(groupPosition: Int, childPosition: Int): Any {
        val list1 = map[list[groupPosition]]
       return list1?.get(childPosition)!!
    }
    override fun getGroupId(groupPosition: Int): Long {
          return groupPosition.toLong()
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
    return childPosition.toLong()
    }

    override fun hasStableIds(): Boolean {
         return true
    }

    override fun getGroupView(groupPosition: Int, isExpanded: Boolean, convertView: View?, parent: ViewGroup?): View {
      var groupItemView:View
      if(convertView==null){
          groupItemView=LayoutInflater.from(parent?.context).inflate(R.layout.group_item,parent,false)
      }else{
          groupItemView=convertView
      }
        groupItemView.text_group.text=list[groupPosition]

        return groupItemView
    }

    override fun getChildView(groupPosition: Int, childPosition: Int, isLastChild: Boolean, convertView: View?, parent: ViewGroup?): View {
         var childitemView:View
         if(convertView==null){
             childitemView=LayoutInflater.from(parent?.context).inflate(R.layout.child_item,parent,false)
         }else{
             childitemView=convertView
         }
        val list1 = map[list[groupPosition]]
        var childitem= list1?.get(childPosition)?.name
        childitemView.text_child.text = childitem
        return childitemView
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
          return true
    }
}