package org.hanif.amazonclone.database

import android.content.Context
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import database.ProductDatabase


/* Created by Hanif on 20/08/24 */

fun getProductDatabase(context: Context): ProductDatabase {
    val dbFile = context.getDatabasePath("product.db")
    return Room.databaseBuilder<ProductDatabase>(
        context.applicationContext,
        name = dbFile.absolutePath
    )
        .setDriver(BundledSQLiteDriver())
        .allowMainThreadQueries().build()
}