package kz.temir.sometestproject.presentation.model

import kz.temir.sometestproject.domain.model.Task
import javax.inject.Inject

class TaskFormatter @Inject constructor() {
    fun format(task: Task): TaskVo {
        return TaskVo(
            id = task.id,
            name = task.name,
            description = task.description,
        )
    }

    fun format(taskVo: TaskVo): Task {
        return Task(
            id = taskVo.id,
            name = taskVo.name,
            description = taskVo.description,
        )
    }
}
