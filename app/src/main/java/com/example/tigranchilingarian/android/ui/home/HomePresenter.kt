package com.example.tigranchilingarian.android.ui.home

import android.util.Log
import com.example.tigranchilingarian.android.data.storage.PreferencesStorage
import com.example.tigranchilingarian.android.di.component.HomeComponent
import com.example.tigranchilingarian.android.domain.TimeTableInteractor
import com.example.tigranchilingarian.android.ui.core.ActivityPresenter
import com.example.tigranchilingarian.android.ui.core.BaseScreen
import kotlinx.coroutines.channels.map
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomePresenter(screen: BaseScreen, component: HomeComponent) : ActivityPresenter<HomePresenter.Screen>(screen) {

    @Inject
    lateinit var preferencesStorage: PreferencesStorage
    @Inject
    lateinit var timeTableInteractor: TimeTableInteractor

    init {
        component.inject(this)
    }

    override fun onStart() {
        super.onStart()
        reactiveJob = launch {
            timeTableInteractor.tasksChanel
                    .openSubscription()
                    .map {
                        Log.d("wtf", "result --- $it")
                    }
        }

        launch {
            try {
                timeTableInteractor.loadTasks("")
            } catch (e: Exception) {
                Log.d("wtf", "${e.printStackTrace()}")
                Log.d("wtf", "$e")
            }
        }
    }

    interface Screen : BaseScreen {

    }
}