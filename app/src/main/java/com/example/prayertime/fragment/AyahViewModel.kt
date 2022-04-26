package com.example.prayertime.fragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.prayertime.model.*
import com.example.prayertime.service.AyahService
import com.example.prayertime.service.QuranService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class AyahViewModel : ViewModel() {
    private val disposable= CompositeDisposable()
    private val ayahService= AyahService()
    val ayahLiveData=MutableLiveData<Surah>()
    val ayaLoading=MutableLiveData<Boolean>()

    fun refreshAyahData(){
        getAyahData()
    }

    private fun getAyahData() {
        disposable.addAll(
            ayahService.getAyahData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<Surah>() {
                    override fun onSuccess(t: Surah ){
                        ayahLiveData.value=t
                        ayaLoading.value=false
                    }

                    override fun onError(e: Throwable) {
                       e.printStackTrace()
                        ayaLoading.value=true
                    }

                }))


    }


}