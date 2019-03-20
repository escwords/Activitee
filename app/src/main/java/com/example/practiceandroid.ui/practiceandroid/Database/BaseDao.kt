package com.example.practiceandroid.ui.practiceandroid.Database

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update

interface BaseDao<T> {

    @Delete
    fun delete(vararg obj:T)

}