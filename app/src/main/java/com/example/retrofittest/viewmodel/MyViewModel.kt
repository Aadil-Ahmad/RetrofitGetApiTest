package com.example.retrofittest.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofittest.model.MyDataModel
import com.example.retrofittest.repository.MyRepository
import kotlinx.coroutines.launch

class MyViewModel(private val repository: MyRepository): ViewModel() {

    private val _myData = MutableLiveData<List<MyDataModel>>()
    val myData: LiveData<List<MyDataModel>> get() = _myData

    fun fetchData(){
        viewModelScope.launch {
            _myData.value = repository.getMyData()
        }
    }
}