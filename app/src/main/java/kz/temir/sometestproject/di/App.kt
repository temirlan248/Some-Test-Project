package kz.temir.sometestproject.di

import android.app.Application

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        applicationComponent = buildApplicationComponent()
    }

    private fun buildApplicationComponent(): ApplicationComponent {
        return DaggerApplicationComponent.builder()
            .databaseModule(DatabaseModule(this))
            .build()
    }

    companion object {
        private var applicationComponent: ApplicationComponent? = null
        fun getAppComponent(): ApplicationComponent? {
            return applicationComponent
        }
    }
}
