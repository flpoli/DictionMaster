package com.example.dictionmaster.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.dictionmaster.data.util.JsonParser
import com.example.dictionmaster.domain.model.*
import com.google.gson.reflect.TypeToken


@ProvidedTypeConverter
class Converters(private val jsonParser: JsonParser) {
 private val separator = ","

    @TypeConverter
    fun fromResultJson(json: String): List<Result> {

        return jsonParser.fromJson<ArrayList<Result>>(
            json,
            object : TypeToken<ArrayList<Result>>(){}.type
        ) ?: emptyList()

    }

    @TypeConverter
    fun toResultJson(results: List<Result>): String {

        return jsonParser.toJson(
            results,
            object: TypeToken<ArrayList<Result>>(){}.type
        ) ?: "[]"

    }


    @TypeConverter
    fun convertListToString(list: List<String>): String {

        val stringBuilder = StringBuilder()

        for (item in list) {
            stringBuilder.append(item).append(separator)
        }

        stringBuilder.setLength(stringBuilder.length - separator.length)

        return stringBuilder.toString()

    }

    @TypeConverter
    fun convertStringToList(string: String): List<String> {

        return string.split(separator)

    }

}