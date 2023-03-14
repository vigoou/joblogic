package com.quoctran.joblogic.domain.usecase

import com.quoctran.joblogic.domain.base.UseCase
import com.quoctran.joblogic.domain.model.Person
import com.quoctran.joblogic.domain.repository.IPersonRepository
import javax.inject.Inject

class GetListPersonUseCase @Inject constructor(private val personRepository: IPersonRepository):
    UseCase<List<Person>, UseCase.None>() {
    override suspend fun run(params: None) = personRepository.getPersonList()

}