package com.example.wyklad10.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
interface SklepyDao {
    @Insert
    fun insert (sklep: Sklep)

    @Update
    fun update(sklep: Sklep)

    @Delete
    fun delete(sklep: Sklep)

    @Query("SELECT * FROM sklepy_table")
    fun getAllSklepy(): LiveData<kotlin.collections.List<Sklep>>




    @Query("DELETE FROM sklepy_table")
    fun deleteAllRows()




}
