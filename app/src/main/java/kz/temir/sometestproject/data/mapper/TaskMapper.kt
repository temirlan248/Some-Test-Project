package kz.temir.sometestproject.data.mapper

import kz.temir.sometestproject.data.cache.TaskDbo
import kz.temir.sometestproject.domain.model.Task
import javax.inject.Inject

class TaskMapper @Inject constructor() {
    fun map(taskDbo: TaskDbo): Task {
        return Task(
            id = taskDbo.id,
            name = taskDbo.name,
            description = taskDbo.description,
        )
    }

    fun map(task: Task): TaskDbo {
        return TaskDbo(
            id = task.id,
            name = task.name,
            description = task.description,
        )
    }
}
