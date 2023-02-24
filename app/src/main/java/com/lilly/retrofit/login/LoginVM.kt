package com.lilly.retrofit.login

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel

class LoginVM: AndroidViewModel(Application()) {
    var userEmail by mutableStateOf("")
    var userPassword by mutableStateOf("")
    var isPasswordVisible by mutableStateOf(true)

    fun passwordChange(NewString: String){
        userPassword = NewString
    }

    fun emailChange(NewString: String){
        userEmail = NewString
    }
}