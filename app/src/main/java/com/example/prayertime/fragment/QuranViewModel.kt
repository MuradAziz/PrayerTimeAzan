package com.example.prayertime.fragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.prayertime.model.Quran
import com.example.prayertime.model.QuranNew
import com.example.prayertime.service.QuranService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class QuranViewModel : ViewModel() {
   private val disposable=CompositeDisposable()
    private val quranService=QuranService()
    val quranLiveData=MutableLiveData<QuranNew>()
    val quranLoading=MutableLiveData<Boolean>()

    fun refreshDataQuran(){
        getQuranData()
    }

    private fun getQuranData() {
        disposable.addAll(
            quranService.getQuranData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<QuranNew>(){
                    override fun onSuccess(t: QuranNew) {
                        quranLiveData.value=t
                        quranLoading.value=false
                    }

                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                        quranLoading.value=true
                    }


                })

        )
    }


}

