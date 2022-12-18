package kz.temir.sometestproject.data.datasource

import kotlinx.coroutines.flow.Flow
import kz.temir.sometestproject.data.cache.TaskDao
import kz.temir.sometestproject.data.cache.TaskDbo
import javax.inject.Inject

class TaskCacheDataSource @Inject constructor(
    private val taskDao: TaskDao,
) {
    fun getTaskList(): Flow<List<TaskDbo>> {
        return taskDao.getAll()
    }

    fun addTask(taskDbo: TaskDbo) {
        return taskDao.insert(taskDbo)
    }

    fun deleteTask(taskDbo: TaskDbo) {
        return taskDao.delete(taskDbo)
    }
}
