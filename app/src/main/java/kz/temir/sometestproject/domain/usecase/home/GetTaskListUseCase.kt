package kz.temir.sometestproject.domain.usecase.home

import kotlinx.coroutines.flow.Flow
import kz.temir.sometestproject.domain.model.Task
import kz.temir.sometestproject.domain.repo.TaskRepository
import javax.inject.Inject

class GetTaskListUseCase @Inject constructor(
    private val repository: TaskRepository,
) {
    fun execute(): Flow<List<Task>> {
        return repository.getTaskList()
    }

}
