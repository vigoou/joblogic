package com.quoctran.joblogic.domain.usecase

import com.quoctran.joblogic.domain.model.Product
import com.quoctran.joblogic.domain.repository.IProductRepository
import javax.inject.Inject

class GetListProductUseCase @Inject constructor(
    private val productRepository : IProductRepository
) {
    suspend fun getListProduct(isLocal: Boolean) : List<Product>{
        return if(isLocal){
            Product.mapFromLocalToDomain(productRepository.getProductListLocal())
        }else{
            Product.mapFromResponseToDomain(productRepository.getProductListRemote())
        }
    }

}