package di

import database.DbClient
import database.getDatabaseBuilder
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

actual val platformModule: Module = module {
    single {
        getDatabaseBuilder()
    }
    singleOf(::DbClient)
}