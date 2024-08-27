package network

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json


/* Created by Hanif on 18/04/24 */

class ProductApiSource {
    val httpClient = HttpClient {
        install(ContentNegotiation) {
            json()
        }
    }

}