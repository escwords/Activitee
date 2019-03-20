package com.example.practiceandroid.ui.practiceandroid

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practiceandroid.R
import com.example.practiceandroid.ui.practiceandroid.Database.MondayItem

class RecyclerViewAdapter internal constructor(context: Context):RecyclerView.Adapter<ActivityViewHolder>(){

     var activityList = emptyList<MondayItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivityViewHolder {
        val layoutView = LayoutInflater.from(parent.context).inflate(R.layout.main_cardview,parent,false)
        return ActivityViewHolder(layoutView)
    }

    override fun getItemCount(): Int {
        return activityList.size
    }

    internal fun setItems(itemList:List<MondayItem>){
        this.activityList = itemList
        notifyDataSetChanged()
    }


    override fun onBindViewHolder(holder: ActivityViewHolder, position: Int) {
        if( position < activityList.size){
            val product = activityList[position]
            holder.courseView.text = product.courseName
            holder.titleView.text = product.title
            holder.lectureView.text = product.lecturer
            holder.venueView.text = product.venue
            holder.start_time.text = product.starttime
            holder.end_time.text = product.endtime
        }

    }


}
