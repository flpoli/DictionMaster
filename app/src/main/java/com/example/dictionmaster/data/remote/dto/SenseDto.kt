package com.example.dictionmaster.data.remote.dto


import com.example.dictionmaster.domain.model.Sense
import com.google.gson.annotations.SerializedName

data class SenseDto(
    @SerializedName("definitions")
    val definitions: List<String>,
    @SerializedName("domainClasses")
    val domainClasses: List<DomainClasse>,
    @SerializedName("examples")
    val examples: List<ExampleDto>,
    @SerializedName("id")
    val id: String,
    @SerializedName("notes")
    val notes: List<Note>,
    @SerializedName("semanticClasses")
    val semanticClasses: List<SemanticClasse>,
    @SerializedName("shortDefinitions")
    val shortDefinitions: List<String>,
    @SerializedName("subsenses")
    val subsenses: List<SubsenseDto>,
    @SerializedName("synonyms")
    val synonyms: List<SynonymX>,
    @SerializedName("thesaurusLinks")
    val thesaurusLinks: List<ThesaurusLinkX>
)

fun SenseDto.toSense(): Sense {

    return Sense(
        definitions = definitions,
        examples = examples.map { it.toExample() },
        shortDefinitions = shortDefinitions,
        subsenses = subsenses.map { it.toSubsense() },
    )

}