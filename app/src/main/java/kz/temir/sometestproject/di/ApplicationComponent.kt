package kz.temir.sometestproject.di

import dagger.Component
import kz.temir.sometestproject.presentation.home.HomeFragment
import javax.inject.Singleton

@Component(
    modules = [
        DatabaseModule::class,
        RepositoryModule::class,
    ]
)
@Singleton
interface ApplicationComponent {
    fun inject(homeFragment: HomeFragment)
}
