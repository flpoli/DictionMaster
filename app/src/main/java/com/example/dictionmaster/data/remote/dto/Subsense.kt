package com.example.dictionmaster.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Subsense(
    @SerializedName("definitions")
    val definitions: List<String>,
    @SerializedName("domainClasses")
    val domainClasses: List<DomainClasseX>,
    @SerializedName("examples")
    val examples: List<ExampleX>,
    @SerializedName("id")
    val id: String,
    @SerializedName("notes")
    val notes: List<NoteX>,
    @SerializedName("semanticClasses")
    val semanticClasses: List<SemanticClasseX>,
    @SerializedName("shortDefinitions")
    val shortDefinitions: List<String>,
    @SerializedName("synonyms")
    val synonyms: List<Synonym>,
    @SerializedName("thesaurusLinks")
    val thesaurusLinks: List<ThesaurusLink>
)