package com.example.androidfundamental.mvpsample.respositorydetail

import android.os.Bundle
import com.example.androidfundamental.R
import com.example.androidfundamental.mvpsample.base.BaseActivity
import com.example.androidfundamental.mvpsample.createtask.ui.TasksActivity.Companion.REPOSITORY_DETAIL
import com.example.androidfundamental.retrofitexample.github.GithubRepo
import kotlinx.android.synthetic.main.activity_repository_detail.*

class RepositoryDetailActivity : BaseActivity<RepositoryDetailPresenter>(), RepositoryDetailView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repository_detail)
        val repoDetail = intent.getParcelableExtra<GithubRepo>(REPOSITORY_DETAIL)
        presenter.showDetails(repoDetail)
        btn_close_detail.setOnClickListener {
            presenter.close()
        }
    }

    override fun showDetails(details: GithubRepo) {
        tv_name.text = details.name
        tv_owner.text = details.owner
        tv_url.text = details.url
    }

    override fun close() {
        finish()
    }

    override fun instantiatePresenter(): RepositoryDetailPresenter {
        return RepositoryDetailPresenter(this)
    }
}
