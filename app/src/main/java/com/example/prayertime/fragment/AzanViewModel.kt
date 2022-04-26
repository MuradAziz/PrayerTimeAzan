package com.example.prayertime.fragment

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.prayertime.model.Salah
import com.example.prayertime.service.AzanApiService
import com.example.prayertime.util.AlarmReceiver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class AzanViewModel : ViewModel() {
     private val disposable=CompositeDisposable()
     private val  azanApiService= AzanApiService()
     val AzanTimeLiveData=MutableLiveData<Salah>()

     fun refreshData(city: String){
     getDataFromApi(city)
     }

     private fun getDataFromApi(city: String) {
          disposable.addAll(
          azanApiService.getData(city)
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

