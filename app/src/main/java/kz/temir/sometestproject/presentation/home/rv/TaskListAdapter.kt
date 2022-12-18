package kz.temir.sometestproject.presentation.home.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kz.temir.sometestproject.databinding.ItemTaskBinding
import kz.temir.sometestproject.presentation.model.TaskVo

class TaskListAdapter : ListAdapter<TaskVo, TaskListAdapter.ViewHolder>(TaskDiffUtil()) {

    private var itemCallback: ((TaskVo) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding =
            ItemTaskBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    fun setItemCallback(callback: ((TaskVo) -> Unit)? = null) {
        this.itemCallback = callback
    }

    inner class ViewHolder(
        viewBinding: ItemTaskBinding,
    ) : RecyclerView.ViewHolder(viewBinding.root) {
        private val nameTv = viewBinding.nameTv
        private val descriptionTv = viewBinding.descriptionTv
        private val deleteBtn = viewBinding.deleteBtn

        fun bind(taskVo: TaskVo) {
            nameTv.text = taskVo.name
            descriptionTv.text = taskVo.description

            deleteBtn.setOnClickListener {
                itemCallback?.invoke(taskVo)
            }
        }
    }
}

class TaskDiffUtil : DiffUtil.ItemCallback<TaskVo>() {
    override fun areItemsTheSame(oldItem: TaskVo, newItem: TaskVo): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: TaskVo, newItem: TaskVo): Boolean {
        return oldItem == newItem
    }
}
