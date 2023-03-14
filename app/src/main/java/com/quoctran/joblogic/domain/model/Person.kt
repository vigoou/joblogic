package com.quoctran.joblogic.domain.model

import com.quoctran.joblogic.data.model.PersonResponse
import com.quoctran.joblogic.data.model.ProductResponse

class Person(
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