package com.example.dictionmaster.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.dictionmaster.data.local.entity.WordInfoEntity

@Database(
    entities = [WordInfoEntity::class],
    version = 1)
@TypeConverters(Converters::class)
abstract class WordInfoDatabase: RoomDatabase() {

    abstract val dao:  WordInfoDao


}