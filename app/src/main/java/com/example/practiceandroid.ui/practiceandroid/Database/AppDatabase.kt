package com.example.practiceandroid.ui.practiceandroid.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.*

@Database(entities = [MondayItem::class], version = 1,exportSchema = false)
abstract class AppDatabase : RoomDatabase(){

    abstract fun mondayItemDao(): MondayDao

    companion object {
        @Volatile private var instance : AppDatabase? = null

        fun getDatabase(context:Context): AppDatabase {
            return instance ?: synchronized(this){
               instance
                   ?: buildDatabase(
                       context
                   ).also { instance = it }
            }
        }
        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context,
                AppDatabase::class.java,"Activitee_practise").build()
        }


      /* private  class PrepopulateCallback(private val  scope: CoroutineScope):RoomDatabase.Callback(){
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                instance?.let { AppDatabase ->
                    scope.launch(Dispatchers.IO) {
                        populateWithData(
                            AppDatabase.mondayItemDao()
                        )
                    }
                }
            }

                }*/


/*
        suspend  fun populateWithData(mondayDao: MondayDao){
            mondayDao.deleteAll()
           *//* withContext(Dispatchers.IO) {
                mondayDao.insert(prepopulate())
            }*//*
            }*/

        /*fun prepopulate():List<MondayItem>{
            val list = ArrayList<MondayItem>()
            for (i in 0..4){
                val model = MondayItem(
                    courseName = courseItem[i],
                    lecturer = lecturerItem[i]
                )
                model.courseName = courseItem[i]
                list.add(model)
            }

       return list

        }*/

/*
private val courseItem = arrayOf("MTH111", "MTH121", "Cos101", "Cos103", "Cose111")
        private val lecturerItem = arrayOf("Mr jude", "MTH133", "mr roy", "Mrs Ugwusishu", "mr Echezona")
        private val venueItem = arrayOf("AbjBuilding", "AbjFlat2", "Abj build.", "Abj Build.", "Abj Build.")
        private val sTime = arrayOf("11:20", "1:30", "1:20", "1:50", "1:21")
        private val eTime = arrayOf("1:20", "2:10", "2:40", "3:20", "2:30")

*/}


}