package database

actual class DbClient {
    actual val database: ProductDatabase
        get() = getDatabaseBuilder().build()
}