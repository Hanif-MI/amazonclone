package database

import androidx.room.Database
import androidx.room.RoomDatabase


/* Created by Hanif on 20/08/24 */

@Database(entities = [ProductEntity::class], version = 1)
abstract class ProductDatabase : RoomDatabase() {

    abstract fun productDao(): ProductDao

}