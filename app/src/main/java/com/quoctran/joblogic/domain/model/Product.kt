package com.quoctran.joblogic.domain.model

import com.quoctran.joblogic.data.db.entity.ProductEntity
import com.quoctran.joblogic.data.model.ProductResponse

data class Product(
    val id: Long,
    val name: String,
    val price: Long,
    val quantity: Int,
    var type: Int
) {
    companion object {
        fun mapFromResponseToDomain(listProductResponse: List<ProductResponse>?) : List<Product>{
            return listProductResponse?.map {
                Product(it.id, it.name, it.price, it.quantity, it.type)
            } ?: listOf()
        }

        fun mapFromLocalToDomain(listProductEntity: List<ProductEntity>?) : List<Product>{
            return listProductEntity?.map {
                Product(it.id, it.name, it.price, it.quantity, it.type)
            } ?: listOf()
        }

        fun mapProductToProductEntity(product: Product) : ProductEntity{
            return ProductEntity(product.name, product.price, product.quantity, 2)
        }
    }
}