package com.quoctran.joblogic.data.model

import com.quoctran.joblogic.domain.model.Person

data class PersonResponse(
    val id: Long,
    val name: String,
    val number: String
) {

    companion object {
        fun mapFromResponseToDomain(listPersonResponse: List<PersonResponse>?) : List<Person>{
            return listPersonResponse?.map {
                Person(it.id, it.name, it.number)
            } ?: listOf()
        }
    }
}