package com.example.androidfundamental.mvpsample.respositorydetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidfundamental.R
import com.example.androidfundamental.mvpsample.createtask.ui.model.RepositoryDetails

class RepositoryDetailActivity : AppCompatActivity(), RepositoryDetailContract.View{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repository_detail)
    }

    override fun showDetails(details: RepositoryDetails) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
