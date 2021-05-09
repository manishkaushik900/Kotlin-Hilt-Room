package com.demo.kotlin.room.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "word_table")//Each @Entity class represents a SQLite table.
data class Word(@PrimaryKey @ColumnInfo(name="word") val word:String)
