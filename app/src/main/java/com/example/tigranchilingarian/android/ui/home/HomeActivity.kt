package com.example.tigranchilingarian.android.ui.home

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.tigranchilingarian.android.di.HomeScreenModule
import com.example.tigranchilingarian.android.ui.core.BaseActivityWithPresenter
import com.example.tigranchilingarian.android.ui.core.Layout
import com.example.tigranchilingarian.android.ui.core.WithBinding
import com.example.tigranchilingarian.calendar_android.R
import com.example.tigranchilingarian.calendar_android.databinding.ActivityHomeBinding

@Layout(R.layout.activity_home)
@WithBinding
class HomeActivity : BaseActivityWithPresenter<HomePresenter.Screen, HomePresenter>(), HomePresenter.Screen {

    private lateinit var binding: ActivityHomeBinding

    val component by lazy {
        app.component.plus(HomeScreenModule(this))
    }

    override fun createPresenter() = HomePresenter(this, component)

    override fun injectComponent() {
        component.plus(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun setupContentWithBinding(layoutId: Int) {
        binding = DataBindingUtil.setContentView(this, layoutId)
    }
}
