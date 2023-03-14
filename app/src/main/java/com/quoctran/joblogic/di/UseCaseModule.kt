package com.quoctran.joblogic.di

import com.quoctran.joblogic.data.repository.ProductRepositoryImpl
import com.quoctran.joblogic.domain.repository.IPersonRepository
import com.quoctran.joblogic.domain.repository.IProductRepository
import com.quoctran.joblogic.domain.usecase.AddProductToLocalUseCase
import com.quoctran.joblogic.domain.usecase.GetListPersonUseCase
import com.quoctran.joblogic.domain.usecase.GetListProductUseCase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object UseCaseModule {
    @Singleton
    @Provides
    fun provideGetListProductUseCase(productRepository: IProductRepository): GetListProductUseCase {
        return GetListProductUseCase(productRepository)
    }

    @Singleton
    @Provides
    fun provideGetListPersonUseCase(personRepository: IPersonRepository): GetListPersonUseCase {
        return GetListPersonUseCase(personRepository)
    }

    @Singleton
    @Provides
    fun provideAddProductToLocalUseCase(productRepository: IProductRepository): AddProductToLocalUseCase {
        return AddProductToLocalUseCase(productRepository)
    }
}