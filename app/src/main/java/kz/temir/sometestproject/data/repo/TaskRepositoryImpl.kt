package kz.temir.sometestproject.data.repo

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kz.temir.sometestproject.data.datasource.TaskCacheDataSource
import kz.temir.sometestproject.data.mapper.TaskMapper
import kz.temir.sometestproject.domain.model.Task
import kz.temir.sometestproject.domain.repo.TaskRepository
import javax.inject.Inject

class TaskRepositoryImpl @Inject constructor(
    private val taskCacheDataSource: TaskCacheDataSource,
    private val taskMapper: TaskMapper,
) : TaskRepository {
    override fun getTaskList(): Flow<List<Task>> {
        return taskCacheDataSource.getTaskList()
            .map { taskDboList ->
                taskDboList.map { taskDbo ->
                    taskMapper.map(taskDbo)
                }
            }
    }

    override fun addTask(task: Task) {
        return taskCacheDataSource.addTask(
            taskMapper.map(task)
        )
    }

    override fun deleteTask(task: Task) {
        return taskCacheDataSource.deleteTask(
            taskMapper.map(task)
        )
    }
}
