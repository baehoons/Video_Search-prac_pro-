package com.example.searchvideo.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LifecycleOwner
import com.example.searchvideo.util.SnackbarMessage
import com.example.searchvideo.util.SnackbarMessageString
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BaseViewModel(application: Application) :AndroidViewModel(application){
    private val snackbarMessage = SnackbarMessage()
    private val snackbarMessageString = SnackbarMessageString()

    /**
     * RxJava 의 observing을 위한 부분.
     * addDisposable을 이용하여 추가하기만 하면 된다
     */
    private val compositeDisposable = CompositeDisposable()

    fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }

    /**
     * 스낵바를 보여주고 싶으면 viewModel 에서 이 함수를 호출
     */
    fun showSnackbar(stringResourceId:Int) {
        snackbarMessage.value = stringResourceId
    }
    fun showSnackbar(str:String){
        snackbarMessageString.value = str
    }

    /**
     * BaseKotlinActivity 에서 쓰는 함수
     */
    fun observeSnackbarMessage(lifeCycleOwner: LifecycleOwner, ob:(Int) -> Unit){
        snackbarMessage.observe(lifeCycleOwner, ob)
    }
    fun observeSnackbarMessageStr(lifeCycleOwner: LifecycleOwner, ob:(String) -> Unit) {
        snackbarMessageString.observe(lifeCycleOwner, ob)
    }
}