package com.quoctran.joblogic.domain.repository

import com.quoctran.joblogic.data.model.PersonResponse


interface IPersonRepository {
    suspend fun getPersonList(): List<PersonResponse>?
}
