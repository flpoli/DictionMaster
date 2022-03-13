package com.example.dictionmaster.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.dictionmaster.data.util.JsonParser
import com.example.dictionmaster.domain.model.Result
import com.google.gson.reflect.TypeToken


@ProvidedTypeConverter
class Converters(private val jsonParser: JsonParser) {

    //private val separator = ","

    @TypeConverter
    fun fromResultJson(json: String): List<Result> {

        return jsonParser.fromJson<ArrayList<Result>>(
            json,
            object : TypeToken<ArrayList<Result>>() {}.type
        ) ?: emptyList()

    }

    @TypeConverter
    fun toResultJson(results: List<Result>): String {

        return jsonParser.toJson(
            results,
            object: TypeToken<ArrayList<Result>>() {}.type
        ) ?: "[]"

    }


//    @TypeConverter
//    fun fromSenseJson(json: String): List<Sense> {
//
//        return jsonParser.fromJson<ArrayList<Sense>>(
//            json,
//            object : TypeToken<ArrayList<Sense>>() {}.type
//        ) ?: emptyList()
//
//    }
//
//
//
//    @TypeConverter
//    fun toSenseJson(sense: List<Sense>): String {
//
//        return jsonParser.toJson(
//            sense,
//            object: TypeToken<ArrayList<Sense>>() {}.type
//        ) ?: "[]"
//
//    }
//
//
//    @TypeConverter
//    fun fromLexicalEntriesJson(json: String): List<LexicalEntry> {
//
//        return jsonParser.fromJson<ArrayList<LexicalEntry>>(
//            json,
//            object : TypeToken<ArrayList<LexicalEntry>>() {}.type
//        ) ?: emptyList()
//
//    }
//
//
//
//    @TypeConverter
//    fun toLexicalEntriesJson(sense: List<LexicalEntry>): String {
//
//        return jsonParser.toJson(
//            sense,
//            object: TypeToken<ArrayList<LexicalEntry>>() {}.type
//        ) ?: "[]"
//
//    }
//
//    @TypeConverter
//    fun fromSubsenseJson(json: String): List<Subsense> {
//
//        return jsonParser.fromJson<ArrayList<Subsense>>(
//            json,
//            object : TypeToken<ArrayList<Subsense>>() {}.type
//        ) ?: emptyList()
//
//    }
//    @TypeConverter
//    fun toSubsenseJson(subsense: List<Subsense>): String {
//
//        return jsonParser.toJson(
//            subsense,
//            object: TypeToken<ArrayList<Subsense>>() {}.type
//        ) ?: "[]"
//
//    }
//
//    @TypeConverter
//    fun fromExampleJson(json: String): List<Example> {
//
//        return jsonParser.fromJson<ArrayList<Example>>(
//            json,
//            object : TypeToken<ArrayList<Example>>() {}.type
//        ) ?: emptyList()
//
//    }
//    @TypeConverter
//    fun toExampleJson(example: List<Example>): String {
//
//        return jsonParser.toJson(
//            example,
//            object: TypeToken<ArrayList<Example>>() {}.type
//        ) ?: "[]"
//
//    }
//
//
//
//    @TypeConverter
//    fun fromEntryJson(json: String): List<Entry> {
//
//        return jsonParser.fromJson<ArrayList<Entry>>(
//            json,
//            object : TypeToken<ArrayList<Entry>>() {}.type
//        ) ?: emptyList()
//
//    }
//    @TypeConverter
//    fun toEntryJson(entry: List<Entry>): String {
//
//        return jsonParser.toJson(
//            entry,
//            object: TypeToken<ArrayList<Entry>>() {}.type
//        ) ?: "[]"
//
//    }
//
//    @TypeConverter
//    fun fromExampleXJson(json: String): List<ExampleX> {
//
//        return jsonParser.fromJson<ArrayList<ExampleX>>(
//            json,
//            object : TypeToken<ArrayList<ExampleX>>() {}.type
//        ) ?: emptyList()
//
//    }
//    @TypeConverter
//    fun toExampleXJson(exampleX: List<ExampleX>): String {
//
//        return jsonParser.toJson(
//            exampleX,
//            object: TypeToken<ArrayList<ExampleX>>() {}.type
//        ) ?: "[]"
//
//    }
//
//
//    @TypeConverter
//    fun fromPronunciationJson(json: String): List<Pronunciation> {
//
//        return jsonParser.fromJson<ArrayList<Pronunciation>>(
//            json,
//            object : TypeToken<ArrayList<Pronunciation>>() {}.type
//        ) ?: emptyList()
//
//    }
//    @TypeConverter
//    fun toPronunciationJson(pronunciation: List<Pronunciation>): String {
//
//        return jsonParser.toJson(
//            pronunciation,
//            object: TypeToken<ArrayList<Pronunciation>>() {}.type
//        ) ?: "[]"
//
//    }
//
//    @TypeConverter
//    fun fromGrammaticalFeaturesJson(json: String): List<GrammaticalFeature> {
//
//        return jsonParser.fromJson<ArrayList<GrammaticalFeature>>(
//            json,
//            object : TypeToken<ArrayList<GrammaticalFeature>>() {}.type
//        ) ?: emptyList()
//
//    }
//    @TypeConverter
//    fun toGrammaticalFeaturesJson(grammaticalFeatures: List<GrammaticalFeature>): String {
//
//        return jsonParser.toJson(
//            grammaticalFeatures,
//            object: TypeToken<ArrayList<GrammaticalFeature>>() {}.type
//        ) ?: "[]"
//
//    }
//
//
//    @TypeConverter
//    fun convertListToString(list: List<String>): String {
//
//        val stringBuilder = StringBuilder()
//
//        for (item in list) {
//            stringBuilder.append(item).append(separator)
//        }
//
//        stringBuilder.setLength(stringBuilder.length - separator.length)
//
//        return stringBuilder.toString()
//
//    }
//
//    @TypeConverter
//    fun convertStringToList(string: String): List<String> {
//
//        return string.split(separator)
//
//    }

}