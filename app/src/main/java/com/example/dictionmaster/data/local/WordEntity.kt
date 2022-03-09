package com.example.dictionmaster.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.dictionmaster.data.remote.dto.Sense
import com.example.dictionmaster.data.remote.dto.Subsense

@Entity
data class WordEntity (

    @PrimaryKey
    val id: Int? = null,
    val word: String,
    val senses: List<Sense>,
    val subSenses: List<Subsense>,
    val spellingIpa: String,
    val audioUrl: String,
)


