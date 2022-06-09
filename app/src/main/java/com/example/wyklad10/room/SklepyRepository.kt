package com.example.wyklad10.room
import android.app.Application
import androidx.lifecycle.LiveData
import kotlinx.coroutines.*


class SklepyRepository (application: Application) {


    private var sklepyDao: SklepyDao

    init {
        val database = SklepyDatabase.getInstance(application.applicationContext)

        sklepyDao = database!!.sklepyDao()

    }



    fun insertSklep(sklep: Sklep) =
        CoroutineScope(Dispatchers.IO).launch {
            sklepyDao.insert(sklep)
        }
    fun updateSklep(sklep: Sklep) =
        CoroutineScope(Dispatchers.IO).launch {
            sklepyDao.update(sklep)
        }
    fun deleteSklep(sklep: Sklep) =
        CoroutineScope(Dispatchers.IO).launch {
            sklepyDao.delete(sklep)
        }

    fun getAllSklepyAsync(): Deferred<LiveData<List<Sklep>>> =
        CoroutineScope(Dispatchers.IO).async {
            sklepyDao.getAllSklepy()
        }

    fun deleteAllRows()=
        CoroutineScope(Dispatchers.IO).launch {
            sklepyDao.deleteAllRows()
        }


}