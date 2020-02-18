package com.example.androidfundamental.mvpsample.createtask.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidfundamental.R
import com.example.androidfundamental.mvpsample.createtask.GitHubContract

class TasksActivity : AppCompatActivity(), GitHubContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tasks)
    }

    override fun setProgressIndicator(active: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showRepositories(repositories: List<String?>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showAddRepository() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showRepositoryDetails(repositoryId: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
