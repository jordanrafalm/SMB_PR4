package com.example.wyklad10.room;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "sklepy_table")
data class Sklep (
    var nazwa: String,
    var opis: String,
    var promien: String,
    var lokalizacja: Double,
    var lokalizacja1: Double
    ) {

    @PrimaryKey(autoGenerate = true)
    var user_id: Int = 0
}
