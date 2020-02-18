package com.example.androidfundamental.mvpsample.injection.component

import com.example.androidfundamental.mvpsample.base.BaseView
import com.example.androidfundamental.mvpsample.createtask.ui.presenter.TaskActivityPresenter
import com.example.androidfundamental.mvpsample.injection.module.ContextModule
import com.example.androidfundamental.mvpsample.injection.module.NetworkModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


/**
 * Component providing inject() methods for presenters.
 */
@Singleton
@Component(modules = [(ContextModule::class), (NetworkModule::class)])
interface PresenterInjector {
    /**
     * Injects required dependencies into the specified Presenter.
     * @param taskActivityPresenter TaskActivityPresenter in which to inject the dependencies
     */
    fun inject(taskActivityPresenter: TaskActivityPresenter)

    @Component.Builder
    interface Builder {
        fun build(): PresenterInjector

        fun networkModule(networkModule: NetworkModule): Builder
        fun contextModule(contextModule: ContextModule): Builder

        @BindsInstance
        fun baseView(baseView: BaseView): Builder
    }
}