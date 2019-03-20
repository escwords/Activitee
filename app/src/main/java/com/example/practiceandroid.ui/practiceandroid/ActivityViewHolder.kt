package com.example.practiceandroid.ui.practiceandroid

import android.view.View
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.recyclerview.widget.RecyclerView
import com.example.practiceandroid.R
import org.jetbrains.annotations.NotNull

class ActivityViewHolder(@NonNull itemView: View):RecyclerView.ViewHolder(itemView) {
    val titleView = itemView.findViewById<TextView>(R.id.title)
    val courseView = itemView.findViewById<TextView>(R.id.course)
    val lectureView = itemView.findViewById<TextView>(R.id.lecturer)
    val venueView = itemView.findViewById<TextView>(R.id.venue)
    val start_time = itemView.findViewById<TextView>(R.id.startTime)
    val end_time = itemView.findViewById<TextView>(R.id.endTime)
}