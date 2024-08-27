package database

import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import java.io.File

fun getDatabaseBuilder(): RoomDatabase.Builder<ProductDatabase> {
    val dbFile = File(System.getProperty("java.io.tmpdir"), "my_room.db")
    return Room.databaseBuilder<ProductDatabase>(
        name = dbFile.absolutePath,
    ).setDriver(BundledSQLiteDriver())
}


