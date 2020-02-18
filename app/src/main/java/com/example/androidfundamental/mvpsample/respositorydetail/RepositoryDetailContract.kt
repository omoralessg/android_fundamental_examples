package com.example.androidfundamental.mvpsample.respositorydetail

import com.example.androidfundamental.mvpsample.createtask.ui.model.RepositoryDetails

interface RepositoryDetailContract {
    interface View{
        fun showDetails(details : RepositoryDetails)
    }

    interface Presenter{
        fun close()
    }
}