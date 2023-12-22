package com.yourbynn.matchingjob.view.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.yourbynn.matchingjob.data.UserModels
import com.yourbynn.matchingjob.data.UserRepository
import kotlinx.coroutines.launch

class MainViewModels(private val repository: UserRepository) : ViewModel()  {
    fun getSession(): LiveData<UserModels> {
        return repository.getSession().asLiveData()
    }

    fun logout() {
        viewModelScope.launch {
            repository.logout()
        }
    }
}