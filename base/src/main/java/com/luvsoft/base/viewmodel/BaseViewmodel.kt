package com.luvsoft.base.viewmodel

import android.app.Activity
import android.content.Intent
import androidx.annotation.CheckResult
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.luvsoft.base.viewmodels.models.FinishActivityModel
import com.rappi.nitro.base.viewModels.models.CustomToastEvent

open class BaseViewModel : ViewModel() {

    protected val closeView = MutableLiveData<FinishActivityModel>()

    protected val customToast = MutableLiveData<CustomToastEvent>()

    protected val loader = MutableLiveData<Boolean>()

    @JvmOverloads
    fun onCloseView(intent: Intent? = null, code: Int = Activity.RESULT_OK) {
        closeView.postValue(
            FinishActivityModel(
                code,
                intent
            )
        )
    }

    open fun hideLoading() {
        loader.postValue(false)
    }

    open fun showLoading() {
        loader.postValue(true)
    }

    @CheckResult
    fun loaderState(): LiveData<Boolean> = loader

    @CheckResult
    fun closeView(): LiveData<FinishActivityModel> = closeView
}