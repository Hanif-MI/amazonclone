package database


import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow


@Dao
interface ProductDao {

    @Upsert
    suspend fun upsertProduct(productEntity: List<ProductEntity>)

    @Delete
    suspend fun deleteProduct(productEntity: ProductEntity)

    @Query("SELECT * FROM products")
    fun getAllProducts(): Flow<List<ProductEntity>>

//    @Query("SELECT EXISTS(SELECT * FROM products)")
//    fun isExists(): Boolean
}