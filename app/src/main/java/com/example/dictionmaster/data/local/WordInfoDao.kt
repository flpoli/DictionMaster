package com.example.dictionmaster.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface WordInfoDao {

   @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun insertWordInfos(infos: List<WordInfoEntity>)

   @Query("SELECT * FROM wordinfoentity WHERE word LIKE '%' || :word || '%'")
   suspend fun getWordInfos(word: String): List<WordInfoEntity>
}