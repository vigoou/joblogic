package com.quoctran.joblogic.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.quoctran.joblogic.data.db.entity.ProductEntity

@Database(
    entities = [
        ProductEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao

}