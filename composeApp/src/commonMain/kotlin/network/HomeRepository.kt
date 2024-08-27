package network

import database.ProductEntity
import domain.models.Product
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    suspend fun getProducts(): List<Product>
    suspend fun getProductById(id: Int):Product
}