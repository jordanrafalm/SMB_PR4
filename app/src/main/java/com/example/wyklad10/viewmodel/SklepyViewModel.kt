package com.example.wyklad10.viewmodel
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

import com.example.wyklad10.room.Sklep
import com.example.wyklad10.room.SklepyRepository
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.runBlocking

class SklepyViewModel(application: Application):
    AndroidViewModel(application) {
    private var sklepyRepository: SklepyRepository =
        SklepyRepository(application)

    private var allSklepy: Deferred<LiveData<List<Sklep>>> =
        sklepyRepository.getAllSklepyAsync()

    fun insertSklep(sklep: Sklep) {

        sklepyRepository.insertSklep(sklep)
    }

    fun updateSklep(sklep: Sklep) {

        sklepyRepository.updateSklep(sklep)
    }

    fun deleteSklep(sklep: Sklep) {

        sklepyRepository.deleteSklep(sklep)

    }

    fun getAllSklepy(): LiveData<List<Sklep>> = runBlocking {
        allSklepy.await()
    }

    fun deleteAllRows() {
        sklepyRepository.deleteAllRows()
    }
}