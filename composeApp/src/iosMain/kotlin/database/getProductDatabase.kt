package database

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import platform.Foundation.NSHomeDirectory // This shall too in Windows.


/* Created by Hanif on 20/08/24 */
fun getPeopleDatabase(): ProductDatabase {
    val dbFile = NSHomeDirectory() + "/people.db"
    return Room.databaseBuilder<ProductDatabase>(
        name = dbFile,
        factory = { ProductDatabase::class.instantiateImpl() }
    )
        .setDriver(BundledSQLiteDriver())
        .build()
}