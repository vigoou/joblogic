package com.quoctran.joblogic.data.model

data class ProductResponse (
    val id: Long,
    val name: String,
    val price: Long,
    val quantity: Int,
    var type: Int = 1
        ){
}