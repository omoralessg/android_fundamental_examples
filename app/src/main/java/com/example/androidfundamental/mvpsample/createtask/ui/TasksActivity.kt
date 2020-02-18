package com.example.androidfundamental.mvpsample.createtask.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidfundamental.MyAdapter
import com.example.androidfundamental.R
import com.example.androidfundamental.databinding.ActivityTasksBinding
import com.example.androidfundamental.mvpsample.base.BaseActivity
import com.example.androidfundamental.mvpsample.createtask.ui.adapter.RecyclerViewAdapter
import com.example.androidfundamental.mvpsample.createtask.ui.presenter.TaskActivityPresenter
import com.example.androidfundamental.mvpsample.createtask.ui.view.TaskView
import kotlinx.android.synthetic.main.activity_recycler_view.*
import kotlinx.android.synthetic.main.activity_tasks.*

class TasksActivity :  GitHubContract.View, BaseActivity<TaskActivityPresenter>(), TaskView {

    private lateinit var recyclerAdapter: RecyclerViewAdapter
    private lateinit var tasksBinding: ActivityTasksBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tasksBinding = DataBindingUtil.setContentView(this, R.layout.activity_tasks)
        hideLoading()
        btn_load_repositories.setOnClickListener {
            presenter.loadRepositories(true)
        }
    }

    override fun setProgressIndicator(active: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showRepositories(repositories: List<String>) {
        recyclerAdapter = RecyclerViewAdapter(repositories)
        tasksBinding.executePendingBindings()
        setupRecyclerView()
    }

    override fun showAddRepository() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showRepositoryDetails(repositoryId: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showError(error: String) {
      Toast.makeText(this, "Error", Toast.LENGTH_LONG).show()
    }

    override fun hideLoading() {
        tasksBinding.progressVisibility = View.GONE
    }

    override fun showLoading() {
        tasksBinding.progressVisibility = View.VISIBLE
    }

    override fun instantiatePresenter(): TaskActivityPresenter {
        return TaskActivityPresenter(this)
    }

    private fun setupRecyclerView() {
        recyclerview_repositories.apply {
            val mLayoutManager = LinearLayoutManager(context)
            val divider = DividerItemDecoration(context, mLayoutManager.orientation)
            addItemDecoration(divider)
            layoutManager = mLayoutManager
            adapter = recyclerAdapter
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onViewDestroyed()
    }
}
