package org.hanif.amazonclone

import android.app.Application
import di.initKoin
import di.platformModule
import org.koin.android.ext.koin.androidContext


/* Created by Hanif on 23/08/24 */

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin(){
            androidContext(this@App)
//            modules(platformModule)
        }
    }
}