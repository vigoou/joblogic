package com.quoctran.joblogic.domain.usecase

import com.quoctran.joblogic.domain.model.Product
import com.quoctran.joblogic.domain.repository.IProductRepository
import javax.inject.Inject

class AddProductToLocalUseCase  @Inject constructor(
    private val productRepository : IProductRepository
) {
    suspend fun addProduct( product: Product) :Long{
        return productRepository.addProductLocal(Product.mapProductToProductEntity(product))
    }

}