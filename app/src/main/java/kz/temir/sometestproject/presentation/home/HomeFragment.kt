package kz.temir.sometestproject.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import kz.temir.sometestproject.databinding.FragmentHomeBinding
import kz.temir.sometestproject.di.App
import kz.temir.sometestproject.presentation.home.rv.TaskListAdapter
import kz.temir.sometestproject.presentation.model.TaskVo
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject

class HomeFragment : MvpAppCompatFragment(), HomeView {

    private var _viewBinding: FragmentHomeBinding? = null
    private val viewBinding get() = _viewBinding!!

    private var adapter: TaskListAdapter? = null

    @Inject
    @InjectPresenter
    lateinit var presenter: HomePresenter

    @ProvidePresenter
    fun providePresenter(): HomePresenter = presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        App.getAppComponent()?.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _viewBinding = FragmentHomeBinding.inflate(inflater, container, false)
        return _viewBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRV()
        setupAddClickListener()
        setupActionDoneListener()
    }

    private fun setupActionDoneListener() = with(viewBinding) {
        descriptionEt.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                onAddClicked()
                return@setOnEditorActionListener true
            }
            return@setOnEditorActionListener false
        }
    }

    private fun setupAddClickListener() = with(viewBinding) {
        addBtn.setOnClickListener {
            onAddClicked()
        }
    }

    private fun onAddClicked() = with(viewBinding) {
        val name = nameEt.text.toString()
        val description = descriptionEt.text.toString()

        presenter.addTask(name, description)

        nameEt.text.clear()
        descriptionEt.text.clear()
    }

    private fun setupRV() = with(viewBinding) {
        adapter = TaskListAdapter()
        adapter?.setItemCallback { taskVo ->
            presenter.deleteTask(taskVo)
        }
        taskRv.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _viewBinding = null
    }

    override fun setData(taskVoList: List<TaskVo>) {
        adapter?.submitList(taskVoList)
    }

}
