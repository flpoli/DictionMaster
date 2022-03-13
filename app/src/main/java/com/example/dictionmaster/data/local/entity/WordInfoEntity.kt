package com.example.dictionmaster.data.local.entity

import androidx.room.*
import com.example.dictionmaster.data.local.Converters
import com.example.dictionmaster.domain.model.Result
import com.example.dictionmaster.domain.model.WordInfo


@Entity
@TypeConverters(Converters::class)
data class WordInfoEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val word: String,
    val results: List<Result>


)

fun WordInfoEntity.toWordInfo(): WordInfo {

    return WordInfo(
        //id = id,
        word = word,
        results = results
    )
}


