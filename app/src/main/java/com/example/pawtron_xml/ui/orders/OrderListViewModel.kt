package com.example.pawtron_xml.ui.orders

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OrderListViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is OrderList Fragment"
    }
    val text: LiveData<String> = _text
}