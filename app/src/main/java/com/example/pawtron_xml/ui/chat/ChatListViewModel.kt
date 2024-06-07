package com.example.pawtron_xml.ui.chat

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ChatListViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is ChatList Fragment"
    }
    val text: LiveData<String> = _text
}