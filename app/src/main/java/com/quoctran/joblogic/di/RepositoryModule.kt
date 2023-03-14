package com.quoctran.joblogic.di

import com.quoctran.joblogic.data.model.ProductResponse
import com.quoctran.joblogic.data.repository.PersonRepositoryImpl
import com.quoctran.joblogic.data.repository.ProductRepositoryImpl
import com.quoctran.joblogic.domain.repository.IPersonRepository
import com.quoctran.joblogic.domain.repository.IProductRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Singleton
    @Binds
    abstract fun bindIProductRepository(productRepositoryImpl: ProductRepositoryImpl): IProductRepository

    @Singleton
    @Binds
    abstract fun bindIPersonRepository(personRepositoryImpl: PersonRepositoryImpl): IPersonRepository
}