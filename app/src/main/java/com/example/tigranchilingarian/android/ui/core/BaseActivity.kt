package com.example.tigranchilingarian.android.ui.core

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.example.tigranchilingarian.android.App
import com.example.tigranchilingarian.android.data.PreferencesStorage
import com.example.tigranchilingarian.android.data.PreferencesStorageImpl
import com.example.tigranchilingarian.calendar_android.R
import com.google.gson.Gson

abstract class BaseActivity : AppCompatActivity() {

    val app get() = application as App

    val prefs: PreferencesStorage by lazy {
        PreferencesStorageImpl(this, Gson())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectComponent()
        setupContent()
    }

    abstract fun injectComponent()

    private fun setupContent() {
        val layout = javaClass.getAnnotation(Layout::class.java)
                ?: throw NullPointerException("Missing the layout Id")
        val withBinding = javaClass.getAnnotation(WithBinding::class.java)
        if (withBinding == null) {
            setContentView(layout.id)
        } else {
            setupContentWithBinding(layout.id)
        }
    }

    open fun setupContentWithBinding(layoutId: Int) {}

    fun startActivity(cls: Class<*>, withFinish: Boolean = false, revertAnimation: Boolean = false, extras: Bundle? = null, singleTop: Boolean = false) {
        val intent = Intent(this, cls)
        if (singleTop) intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK.or(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        extras?.let { intent.putExtras(extras) }
        startActivity(intent)
        if (revertAnimation) overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right)
        if (withFinish && !singleTop) finish()
    }

    fun startActivityForResult(cls: Class<*>, requestCode: Int, options: Bundle? = null, withFinish: Boolean = false, revertAnimation: Boolean = false, extras: Bundle? = null, singleTop: Boolean = false) {
        val intent = Intent(this, cls)
        if (singleTop) intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK.or(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        extras?.let { intent.putExtras(extras) }
        startActivityForResult(intent, requestCode, options)
        if (revertAnimation) overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right)
        if (withFinish && !singleTop) finish()
    }

    fun hideKeyboard(view: View? = this.currentFocus) {
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    fun showKeyboard() {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT, 0)
    }
}