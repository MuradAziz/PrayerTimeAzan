package com.example.prayertime.fragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.prayertime.model.Salah
import com.example.prayertime.service.AzanApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class AzanViewModel : ViewModel() {
     private val disposable=CompositeDisposable()
     private val  azanApiService= AzanApiService()
     val AzanTimeLiveData=MutableLiveData<Salah>()

     fun refreshData(){
     getDataFromApi()
     }

     private fun getDataFromApi() {
          disposable.addAll(
          azanApiService.getData()
          .subscribeOn(Schedulers.newThread())
          .observeOn(AndroidSchedulers.mainThread())
          .subscribeWith(object : DisposableSingleObserver<Salah>() {
          override fun onSuccess(t: Salah) {
          AzanTimeLiveData.value=t
          }

          override fun onError(e: Throwable) {
          e.printStackTrace()
          }

     })
)
}
     }

