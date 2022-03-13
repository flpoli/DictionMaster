package com.example.dictionmaster.data.local

import androidx.room.*
import com.example.dictionmaster.data.local.entity.WordInfoEntity

@Dao
interface WordInfoDao {

   @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun insertWordInfos(infos: WordInfoEntity)

   @Query("SELECT * FROM wordinfoentity WHERE word LIKE '%' || :word || '%'")
   suspend fun getWordInfos(word: String): WordInfoEntity
}