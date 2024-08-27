package database

import androidx.room.Entity
import androidx.room.PrimaryKey


/* Created by Hanif on 14/08/24 */

@Entity(tableName = "products")
data class ProductEntity(
    val category: String,
    val creationAt: String,
    val description: String,
    @PrimaryKey val id: Int,
    val images: String,
    val price: Int,
    val title: String,
    val updatedAt: String
)