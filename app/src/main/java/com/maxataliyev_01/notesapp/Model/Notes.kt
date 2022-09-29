package com.maxataliyev_01.notesapp.Model


import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Notes")
data class Notes (
    @PrimaryKey(autoGenerate = true)
    var id:Int?=null,
    var title:String,
    var subtitle:String,
    var notes:String,
    var date:String,
    var priority: String

        )