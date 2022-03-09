package com.example.dictionmaster.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

//@Database(entities = [RoomDatabase::class], version = 1)   // change entities later
abstract class WordDb: RoomDatabase() {

    abstract fun wordDao(): WordDao
}