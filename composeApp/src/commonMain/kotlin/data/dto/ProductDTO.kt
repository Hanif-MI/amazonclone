package data.dto

import database.ProductEntity
import domain.models.Category
import domain.models.Product
import utils.dataClassToString
import utils.listToString
import utils.stringToDataClass
import utils.stringToList


/* Created by Hanif on 21/08/24 */


fun ProductEntity.toProduct() = Product(
    category = stringToDataClass<Category>(category),
    description = description,
    id = id,
    price = price,
    title = title,
    updatedAt = updatedAt,
    creationAt = creationAt,
    images = stringToList<String>(images),
)

fun Product.toProductEntity() = ProductEntity(
    category = dataClassToString(category),
    description = description,
    id = id,
    price = price,
    title = title,
    updatedAt = updatedAt,
    creationAt = creationAt,
    images = listToString(images),
)

fun List<Product>.toProductEntityList(): List<ProductEntity> {
    return this.map { it.toProductEntity() }
}
fun List<ProductEntity>.toProductList(): List<Product> {
    return this.map { it.toProduct() }
}