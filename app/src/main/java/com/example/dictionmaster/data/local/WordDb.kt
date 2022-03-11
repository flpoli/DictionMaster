package com.example.dictionmaster.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.dictionmaster.domain.model.WordDefinition

//@Database(entities = [WordDefinition::class], version = 1)
@TypeConverters(DatabaseConverter::class)
abstract class WordDb: RoomDatabase() {

    abstract fun wordDao(): WordDao
}