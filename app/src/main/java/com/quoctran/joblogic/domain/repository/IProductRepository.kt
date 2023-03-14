package com.quoctran.joblogic.domain.repository

import androidx.paging.PagingSource
import com.quoctran.joblogic.data.db.entity.ProductEntity
import com.quoctran.joblogic.data.model.ProductResponse

interface IProductRepository {
    suspend fun getProductListLocal() : List<ProductEntity>?

    suspend fun getProductListRemote() : List<ProductResponse>?

    suspend fun addProductLocal(product :ProductEntity) : Long
}