package kz.temir.sometestproject.presentation.home

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kz.temir.sometestproject.domain.model.Task
import kz.temir.sometestproject.domain.usecase.HomeUseCases
import kz.temir.sometestproject.presentation.model.TaskFormatter
import kz.temir.sometestproject.presentation.model.TaskVo
import moxy.InjectViewState
import moxy.MvpPresenter
import moxy.presenterScope
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

@InjectViewState
class HomePresenter @Inject constructor(
    private val useCases: HomeUseCases,
    private val taskFormatter: TaskFormatter,
) : MvpPresenter<HomeView>() {

    private var job: Job = Job()
        get() {
            if (field.isCancelled) {
                job = Job()
            }
            return field
        }

    private val coroutineContext: CoroutineContext = Dispatchers.IO

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        useCases.getTaskFlow()
            .flowOn(coroutineContext)
            .map { taskList ->
                taskList.map { task ->
                    taskFormatter.format(task)
                }
            }
            .onEach { taskVoList ->
                viewState.setData(taskVoList)
            }
            .launchIn(presenterScope)
    }

    fun addTask(name: String, description: String) {
        presenterScope.launch(coroutineContext) {
            val task = Task(name = name, description = description)
            useCases.addTask(task)
        }
    }

    fun deleteTask(taskVo: TaskVo) {
        presenterScope.launch(coroutineContext) {
            val task = taskFormatter.format(taskVo)
            useCases.deleteTask(task)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }
}
