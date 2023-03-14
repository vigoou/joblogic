package com.quoctran.joblogic.data.repository

import android.util.Log
import androidx.paging.PagingSource
import com.quoctran.joblogic.data.db.ProductDao
import com.quoctran.joblogic.data.db.entity.ProductEntity
import com.quoctran.joblogic.data.model.ProductResponse
import com.quoctran.joblogic.data.network.ApiService
import com.quoctran.joblogic.domain.repository.IProductRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val productDao: ProductDao,
    private val apiService: ApiService
) : IProductRepository {

    override suspend fun getProductListLocal(): List<ProductEntity>?{
        return productDao.getListProduct()
    }

    override suspend fun getProductListRemote(): List< ProductResponse>? {
        return apiService.getListProduct().body()
    }

    override suspend fun addProductLocal(product: ProductEntity) : Long {
        return productDao.addProduct(product)
    }
}