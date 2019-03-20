package com.example.practiceandroid.ui.practiceandroid.Database

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
abstract class MondayDao:
    BaseDao<MondayItem> {

    @Query("SELECT *FROM mondayItem")
    abstract fun loadAllData():LiveData<List<MondayItem>>

    @Query("UPDATE mondayItem SET course = :courseN,title = :titleN,lecturer = :lecturerN, venue = :venueN,start_Time = :startT,end_Time = :endT WHERE id =:id")
      abstract  fun update(
        id:Int,
        courseN:String?,
        titleN:String?,
        lecturerN:String?,
        venueN:String?,
        startT:String?,
        endT:String?
    )
/*
    @Update
    abstract fun update(mondayItem: MondayItem)*/

    @Insert
    abstract fun insert(mondayItem:MondayItem)


    @Query("DELETE FROM mondayItem WHERE id = :id ")
    abstract fun delete(id:Int)
}