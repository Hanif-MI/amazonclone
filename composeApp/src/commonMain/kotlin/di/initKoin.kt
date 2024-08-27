package di

import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration


/* Created by Hanif on 23/08/24 */

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
            modules(
                platformModule,
                sharedModules
            )
    }
}