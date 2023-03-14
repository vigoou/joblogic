package com.quoctran.joblogic.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "product"
)
data class ProductEntity(
    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "price")
    var price: Long,

    @ColumnInfo(name = "quantity")
    var quantity: Int = 0,

    @ColumnInfo(name = "type")
    var type: Int = 1,
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long = 0

}