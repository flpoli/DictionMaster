package com.example.dictionmaster.data.local

import androidx.room.Dao
import com.example.dictionmaster.data.remote.dto.WordDefinitionDto
import retrofit2.http.Query

@Dao
interface WordDao {

   //@Query() add later
   fun getWordDef(word: String): WordDefinitionDto
}