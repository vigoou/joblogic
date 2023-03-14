package com.quoctran.joblogic.presentation.model

import com.quoctran.joblogic.domain.model.Product

data class ProductUI(
    val id: Long,
    val name: String,
    val price: Long,
    val quantity: Int,
    var type: Int
) {
    companion object {
        fun mapFromDomain(listProduct: List<Product>?): List<ProductUI> {
            return listProduct?.filterNotNull()?.map {
                ProductUI(it.id, it.name, it.price, it.quantity, it.type)
            } ?: listOf()
        }
        fun mapToDomain(productUI: ProductUI): Product {
            return  Product(-1,  productUI.name, productUI.price, productUI.quantity, productUI.type)
        }
    }
}