package database

import android.content.Context
import org.hanif.amazonclone.database.getProductDatabase
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject


actual class DbClient(private val context: Context) : KoinComponent {

    actual val database: ProductDatabase by lazy {
        val db: ProductDatabase by inject()
        db
    }
}