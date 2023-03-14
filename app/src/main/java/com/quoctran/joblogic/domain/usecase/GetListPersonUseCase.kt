package com.quoctran.joblogic.domain.usecase

import com.quoctran.joblogic.domain.model.Person
import com.quoctran.joblogic.domain.repository.IPersonRepository
import javax.inject.Inject

class GetListPersonUseCase @Inject constructor(private val personRepository: IPersonRepository) {

    suspend fun getListPerson(): List<Person> {
        return Person.mapFromResponseToDomain(personRepository.getPersonList())
    }
}