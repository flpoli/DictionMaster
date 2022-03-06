package com.example.dictionmaster.domain.model

sealed class Language(val lang: String) {

    object English: Language("en-gb")
    object Spanish: Language("es")
    object French: Language("fr")

    companion object {
        fun fromString(lang: String): Language{

            return when(lang){
                "en-gb" -> English
                "es" -> Spanish
                "fr" -> French
                else -> English
            }
        }
    }
}