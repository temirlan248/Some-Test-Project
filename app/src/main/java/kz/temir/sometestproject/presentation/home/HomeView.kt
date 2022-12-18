package kz.temir.sometestproject.presentation.home

import kz.temir.sometestproject.presentation.model.TaskVo
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

interface HomeView : MvpView {
    @AddToEndSingle
    fun setData(taskVoList: List<TaskVo>)
}
