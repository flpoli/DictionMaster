package com.example.dictionmaster.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Sense(
    @SerializedName("definitions")
    val definitions: List<String>,
    @SerializedName("domainClasses")
    val domainClasses: List<DomainClasse>,
    @SerializedName("examples")
    val examples: List<Example>,
    @SerializedName("id")
    val id: String,
    @SerializedName("notes")
    val notes: List<Note>,
    @SerializedName("semanticClasses")
    val semanticClasses: List<SemanticClasse>,
    @SerializedName("shortDefinitions")
    val shortDefinitions: List<String>,
    @SerializedName("subsenses")
    val subsenses: List<Subsense>,
    @SerializedName("synonyms")
    val synonyms: List<SynonymX>,
    @SerializedName("thesaurusLinks")
    val thesaurusLinks: List<ThesaurusLinkX>
)