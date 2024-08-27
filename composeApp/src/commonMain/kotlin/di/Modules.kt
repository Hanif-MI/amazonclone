package di


import data.HomeRepoImpl
import network.HomeRepository
import network.ProductApiSource
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import presentation.home.HomeViewModel

/* Created by Hanif on 23/08/24 */

expect val platformModule: Module

val sharedModules = module {
    single { ProductApiSource() }
//    single {
//        HomeRepoImpl(ProductApiSource(), get())
//    }.bind<HomeRepository>()
    singleOf(::HomeRepoImpl).bind<HomeRepository>()
    viewModelOf(::HomeViewModel)
}