package kz.temir.sometestproject.domain.usecase

import kotlinx.coroutines.flow.Flow
import kz.temir.sometestproject.domain.model.Task
import kz.temir.sometestproject.domain.usecase.home.AddTaskUseCase
import kz.temir.sometestproject.domain.usecase.home.DeleteTaskUseCase
import kz.temir.sometestproject.domain.usecase.home.GetTaskListUseCase
import javax.inject.Inject

class HomeUseCases @Inject constructor(
    private val addTaskUseCase: AddTaskUseCase,
    private val deleteTaskUseCase: DeleteTaskUseCase,
    private val getTaskListUseCase: GetTaskListUseCase,
) {
    fun addTask(task: Task) {
        return addTaskUseCase.execute(task)
    }

    fun deleteTask(task: Task) {
        return deleteTaskUseCase.execute(task)
    }

    fun getTaskFlow(): Flow<List<Task>> {
        return getTaskListUseCase.execute()
    }
}
