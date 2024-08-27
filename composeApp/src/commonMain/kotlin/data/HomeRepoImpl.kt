package data

import data.dto.toProductEntityList
import database.DbClient
import domain.models.Product
import io.ktor.client.call.body
import io.ktor.client.request.get
import network.HomeRepository
import network.ProductApiSource


/* Created by Hanif on 18/04/24 */

private const val BASEURL = "https://api.escuelajs.co/api/v1/products"

class HomeRepoImpl(private val api: ProductApiSource, private val db: DbClient) :
    HomeRepository {
    override suspend fun getProducts(): List<Product> {
        val result = api.httpClient.get(BASEURL).body<List<Product>>()
        db.database.productDao().upsertProduct(result.toProductEntityList())
        return result
    }

    override suspend fun getProductById(id: Int): Product {

        return api.httpClient.get(BASEURL + "$id").body<Product>()
    }
}