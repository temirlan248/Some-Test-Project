package kz.temir.sometestproject.di

import dagger.Binds
import dagger.Module
import kz.temir.sometestproject.data.repo.TaskRepositoryImpl
import kz.temir.sometestproject.domain.repo.TaskRepository

@Module
abstract class RepositoryModule {
    @Binds
    abstract fun bindsTaskRepository(taskRepositoryImpl: TaskRepositoryImpl): TaskRepository
}