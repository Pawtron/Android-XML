package com.example.pawtron_xml.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class AuthViewModel : ViewModel() {

    private val auth : FirebaseAuth = Firebase.auth

    private val _isLoggedIn = MutableLiveData<Boolean>()
    val isLoggedIn : LiveData<Boolean> = _isLoggedIn


    fun checkCurrent(){
        val currentUser = auth.currentUser

        if (currentUser != null){
            _isLoggedIn.value = true
        } else{
            _isLoggedIn.value = false
        }
    }
}