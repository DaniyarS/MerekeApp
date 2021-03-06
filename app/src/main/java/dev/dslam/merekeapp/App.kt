package dev.dslam.merekeapp

import android.app.Application
import dev.dslam.merekeapp.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(listOf(databaseModule, apiModule, netModule, viewModelModule, repositoryModule))
        }
    }
}
