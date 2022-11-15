package com.example.myapplication.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.DummyData
import com.example.myapplication.Product
import com.example.myapplication.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {
    private var dummyLiveData = MutableLiveData<List<Product>>()
    fun getDummyData() {
        RetrofitInstance.api.getDummyData()
            .enqueue(object: Callback<DummyData> {
            override fun onResponse(call: Call<DummyData>, response: Response<DummyData>) {
                if (response.body()!=null) {
                    dummyLiveData.value = response.body()!!.products
                } else {
                    return
                }
            }
            override fun onFailure(call: Call<DummyData>, t: Throwable) {
                Log.d("TAG",t.message.toString())
            }
        })
    }
    fun observeDummyLiveData() : LiveData<List<Product>> {
        return dummyLiveData
    }
}