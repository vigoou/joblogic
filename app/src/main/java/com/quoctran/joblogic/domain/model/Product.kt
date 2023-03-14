package com.quoctran.joblogic.domain.model
data class Product(
    val id: Long,
    val name: String,
    val price: Long,
    val quantity: Int,
    var type: Int
) {
}