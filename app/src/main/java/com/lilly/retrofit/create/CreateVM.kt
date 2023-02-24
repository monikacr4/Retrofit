package com.lilly.retrofit.create

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel

class CreateVM(): AndroidViewModel(Application()) {
    var name by mutableStateOf("")
    var password by mutableStateOf("")
    var email by mutableStateOf("")

    fun onNameChange(NewString: String){
        name = NewString
    }

    fun onPasswordChange(NewString: String){
        password = NewString
    }

    fun onEmailChange(NewString: String){
        email = NewString
    }
}