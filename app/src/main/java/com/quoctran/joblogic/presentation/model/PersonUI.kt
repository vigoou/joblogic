package com.quoctran.joblogic.presentation.model

import com.quoctran.joblogic.domain.model.Person

data class PersonUI(
    val id: Long,
    val name: String,
    val number: String
) {
    companion object {
        fun mapFromDomainToUI(listPerson: List<Person>?): List<PersonUI> {
            return listPerson?.map {
                PersonUI(it.id, it.name, it.number)
            } ?: listOf()
        }
    }
}