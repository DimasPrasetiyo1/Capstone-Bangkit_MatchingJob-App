package com.yourbynn.matchingjob.view.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yourbynn.matchingjob.data.UserModels
import com.yourbynn.matchingjob.data.UserRepository
import kotlinx.coroutines.launch

class LoginViewModels(private val repository: UserRepository) : ViewModel(){
    fun saveSession(user: UserModels) {
        viewModelScope.launch {
            repository.saveSession(user)
        }
    }
}