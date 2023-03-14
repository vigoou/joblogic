package com.quoctran.joblogic.domain.usecase

import com.quoctran.joblogic.domain.base.UseCase
import com.quoctran.joblogic.domain.model.Product
import com.quoctran.joblogic.domain.repository.IProductRepository
import javax.inject.Inject

class GetListProductUseCase @Inject constructor(
    private val productRepository: IProductRepository
) : UseCase<List<Product>, GetListProductUseCase.Params>() {
    override suspend fun run(params: Params): List<Product> {
        return if (params.isLocal) {
            productRepository.getProductListLocal()
        } else {
            productRepository.getProductListRemote()
        }
    }

    data class Params(
        val isLocal: Boolean
    )
}