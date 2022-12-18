package kz.temir.sometestproject.domain.usecase.home

import kz.temir.sometestproject.domain.model.Task
import kz.temir.sometestproject.domain.repo.TaskRepository
import javax.inject.Inject

class DeleteTaskUseCase @Inject constructor(
    private val repository: TaskRepository
) {
    fun execute(task: Task) {
        repository.deleteTask(task)
    }
}
