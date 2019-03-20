package com.example.practiceandroid.ui.practiceandroid.ActiviteesViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.practiceandroid.ui.practiceandroid.Database.AppDatabase
import com.example.practiceandroid.ui.practiceandroid.Database.MondayItem
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MondayViewModel(applicationContext:Application):AndroidViewModel(applicationContext) {

    private val parentJob = Job()
   private val coroutineContext:CoroutineContext
    get() = parentJob + Dispatchers.Main

    val scope = CoroutineScope(coroutineContext)


    private val mondayRepository: MondayRepository
     val allMondayItems:LiveData<List<MondayItem>>

    init {
        val mondayDbReference = AppDatabase.getDatabase(applicationContext).mondayItemDao()
        mondayRepository =
            MondayRepository(mondayDbReference)
        allMondayItems = mondayRepository.allMondayItem
    }

    fun insert(mondayItem: MondayItem) = scope.launch(Dispatchers.IO) {
        mondayRepository.insert(mondayItem)
    }

    fun update(id:Int,value1:String?,value2:String?,value3:String?,value4: String?,value5: String?,value6: String?)=scope.launch(Dispatchers.IO) {
        mondayRepository.update(id,value1,value2,value3,value4,value5,value6)
    }
/*
    fun update(mondayItem: MondayItem) = scope.launch(Dispatchers.IO) {
        mondayRepository.update(mondayItem)
    }*/


    fun delete(id: Int) = scope.launch(Dispatchers.IO){
        mondayRepository.delete(id)
    }
}