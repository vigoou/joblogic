package com.quoctran.joblogic.domain.repository
import com.quoctran.joblogic.domain.model.Product

interface IProductRepository {
    suspend fun getProductListLocal() : List<Product>

    suspend fun getProductListRemote() : List<Product>

    suspend fun addProductLocal(product : Product) : Long
}