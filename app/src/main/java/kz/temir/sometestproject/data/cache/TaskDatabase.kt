package kz.temir.sometestproject.data.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import javax.inject.Singleton

@Database(entities = [TaskDbo::class], version = 1)
abstract class TaskDatabase : RoomDatabase() {
    @Singleton
    abstract fun taskDao(): TaskDao
}
