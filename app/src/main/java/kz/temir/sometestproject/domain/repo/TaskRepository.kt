package kz.temir.sometestproject.domain.repo

import kotlinx.coroutines.flow.Flow
import kz.temir.sometestproject.domain.model.Task

interface TaskRepository {
    fun getTaskList(): Flow<List<Task>>

    fun addTask(task: Task)

    fun deleteTask(task: Task)
}
