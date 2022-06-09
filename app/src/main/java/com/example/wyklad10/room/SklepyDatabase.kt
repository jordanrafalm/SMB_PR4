package com.example.wyklad10.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.time.chrono.HijrahChronology
import java.time.chrono.HijrahChronology.INSTANCE

@Database(entities = [Sklep::class], version = 5,exportSchema = false)
abstract class SklepyDatabase: RoomDatabase() {

    abstract fun sklepyDao(): SklepyDao

    companion object {
        private var instance: SklepyDatabase? = null

        fun getInstance(context: Context): SklepyDatabase? {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context,
                    SklepyDatabase::class.java,
                    "sklepy_table"
                )
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance
        }

        fun deleteInstanceOfDatabase() {
            instance = null
        }
    }


            }


