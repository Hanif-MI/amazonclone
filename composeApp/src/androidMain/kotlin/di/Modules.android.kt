package di

import database.DbClient
import database.ProductDatabase
import org.hanif.amazonclone.database.getProductDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

actual val platformModule: Module = module {
    single {
        getProductDatabase(androidContext())
    }
    single {
        get<ProductDatabase>().productDao()
    }
    singleOf(::DbClient)
}