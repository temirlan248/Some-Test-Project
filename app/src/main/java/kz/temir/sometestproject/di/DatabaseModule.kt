package kz.temir.sometestproject.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import kz.temir.sometestproject.data.cache.TaskDao
import kz.temir.sometestproject.data.cache.TaskDatabase
import javax.inject.Singleton

@Module
class DatabaseModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideTaskDatabase(): TaskDatabase {
        return Room.databaseBuilder(
            context,
            TaskDatabase::class.java,
            "task-db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideTaskDao(taskDatabase: TaskDatabase): TaskDao {
        return taskDatabase.taskDao()
    }
}
