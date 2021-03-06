package com.mydigipay.challenge.core

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import org.koin.android.ext.android.inject

abstract class BaseActivity : AppCompatActivity() {

    val sharedPref: SharedPreferences by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindView()
    }

    abstract fun bindView()

    fun bindView(layoutId: Int, variableId: Int, viewModel: ViewModel) {
        (DataBindingUtil.setContentView(this, layoutId) as ViewDataBinding).apply {
            setVariable(variableId, viewModel)
            executePendingBindings()
        }
    }

    fun bindView(layoutId: Int) {
        (DataBindingUtil.setContentView(this, layoutId) as ViewDataBinding).apply {
            executePendingBindings()
        }
    }

}