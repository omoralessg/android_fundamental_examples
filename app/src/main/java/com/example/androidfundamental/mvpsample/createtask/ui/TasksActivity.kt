package com.example.androidfundamental.mvpsample.createtask.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidfundamental.R
import com.example.androidfundamental.databinding.ActivityTasksBinding
import com.example.androidfundamental.mvpsample.base.BaseActivity
import com.example.androidfundamental.mvpsample.createtask.ui.adapter.RecyclerViewAdapter
import com.example.androidfundamental.mvpsample.createtask.ui.presenter.TaskActivityPresenter
import com.example.androidfundamental.mvpsample.createtask.ui.view.TaskView
import com.example.androidfundamental.mvpsample.respositorydetail.RepositoryDetailActivity
import kotlinx.android.synthetic.main.activity_tasks.*
import com.example.androidfundamental.retrofitexample.github.GithubRepo

class TasksActivity : BaseActivity<TaskActivityPresenter>(), TaskView,
    RecyclerViewAdapter.OnItemClickListener {

    private lateinit var recyclerAdapter: RecyclerViewAdapter
    private lateinit var tasksBinding: ActivityTasksBinding

    companion object {
        const val REPOSITORY_DETAIL = "REPOSITORY_DETAIL"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tasksBinding = DataBindingUtil.setContentView(this, R.layout.activity_tasks)
        hideLoading()
        btn_load_repositories.setOnClickListener {
            presenter.loadRepositories(true)
        }
    }

    override fun showRepositories(repositories: List<GithubRepo?>?) {
        recyclerAdapter = RecyclerViewAdapter(repositories, this)
        tasksBinding.executePendingBindings()
        setupRecyclerView()
    }

    override fun showAddRepository() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showRepositoryDetails(githubRepo: GithubRepo) {
        val intent = Intent(this, RepositoryDetailActivity::class.java)
        intent.putExtra(REPOSITORY_DETAIL, githubRepo)
        startActivity(intent)
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

    override fun onItemClicked(githubRepo: GithubRepo) {
        presenter.openRepositoryDetails(githubRepo)
    }
}
