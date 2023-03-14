package com.quoctran.joblogic.domain.repository
import com.quoctran.joblogic.domain.model.Person

interface IPersonRepository {
    suspend fun getPersonList(): List<Person>
}
