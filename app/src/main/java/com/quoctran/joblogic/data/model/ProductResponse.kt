package com.quoctran.joblogic.data.model

import com.quoctran.joblogic.domain.model.Product

data class ProductResponse (
    val id: Long,
    val name: String,
    val price: Long,
    val quantity: Int,
    var type: Int = 1
        ){
    companion object {
        fun mapFromResponseToDomain(listProductResponse: List<ProductResponse>?): List<Product> {
            return listProductResponse?.map {
                Product(it.id, it.name, it.price, it.quantity, it.type)
            } ?: listOf()
        }
    }
}