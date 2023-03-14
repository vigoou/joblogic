package com.quoctran.joblogic.data.repository

import com.quoctran.joblogic.data.model.PersonResponse
import com.quoctran.joblogic.data.model.PersonResponse.Companion.mapFromResponseToDomain
import com.quoctran.joblogic.data.network.ApiService
import com.quoctran.joblogic.domain.model.Person
import com.quoctran.joblogic.domain.repository.IPersonRepository
import javax.inject.Inject

class PersonRepositoryImpl @Inject constructor(
private val apiService: ApiService) : IPersonRepository {
    override suspend fun getPersonList(): List<Person> {
        return mapFromResponseToDomain(apiService.getListPerson().body())
    }
}