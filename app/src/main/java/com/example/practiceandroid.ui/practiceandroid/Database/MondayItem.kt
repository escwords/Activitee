package com.example.practiceandroid.ui.practiceandroid.Database

import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "mondayItem")
data class MondayItem(
    //@PrimaryKey(autoGenerate = true) val id: Int,
    @PrimaryKey(autoGenerate = true) val id:Int,
    @ColumnInfo(name = "course") var courseName:String,
    @ColumnInfo(name="title") var title:String? = null,
    @ColumnInfo(name = "lecturer") var lecturer:String? = null,
    @ColumnInfo(name = "venue") var venue:String? = null,
    @ColumnInfo(name = "Start_Time") var starttime:String? = null,
    @ColumnInfo(name = "End_Time") var endtime:String? = null
)