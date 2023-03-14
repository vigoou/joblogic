package com.quoctran.joblogic.data.db

import androidx.paging.PagingSource
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Dao
import com.quoctran.joblogic.data.db.entity.ProductEntity

@Dao
interface ProductDao {

    @Insert
    fun addProduct(productEntity: ProductEntity) : Long

    @Query("SELECT * FROM product")
    suspend fun getListProduct() : List<ProductEntity>
}