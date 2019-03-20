package com.example.practiceandroid.ui.practiceandroid.ActiviteesViewModel

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.practiceandroid.ui.practiceandroid.Database.MondayDao
import com.example.practiceandroid.ui.practiceandroid.Database.MondayItem

class MondayRepository(val mondayDao: MondayDao) {

    val allMondayItem: LiveData<List<MondayItem>> = mondayDao.loadAllData()

    @WorkerThread
    suspend fun insert(mondayItem: MondayItem){
        mondayDao.insert(mondayItem)
    }

    @WorkerThread
    suspend fun update(id:Int,value1:String?,value2:String?,value3:String?,value4: String?,value5: String?,value6: String?){
        mondayDao.update(id,value1,value2,value3,value4,value5,value6)
    }
   /* @WorkerThread
    suspend fun update(mondayItem: MondayItem){
       mondayDao.update(mondayItem)
   }*/

    @WorkerThread
    suspend fun delete(id: Int){
        mondayDao.delete(id)
    }
}
