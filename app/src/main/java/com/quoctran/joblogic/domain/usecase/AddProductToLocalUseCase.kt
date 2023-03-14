package com.quoctran.joblogic.domain.usecase
import com.quoctran.joblogic.domain.base.UseCase
import com.quoctran.joblogic.domain.model.Product
import com.quoctran.joblogic.domain.repository.IProductRepository
import javax.inject.Inject

class AddProductToLocalUseCase  @Inject constructor(
    private val productRepository : IProductRepository
) : UseCase<Long, AddProductToLocalUseCase.Params>() {

    override suspend fun run(params: Params)= productRepository.addProductLocal(params.product)


    data class Params(
        val product: Product
    )

}