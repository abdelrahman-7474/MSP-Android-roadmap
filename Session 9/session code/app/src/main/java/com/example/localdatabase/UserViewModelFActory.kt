package com.example.localdatabase

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class UserViewModelFActory(val repo: Repo):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if(modelClass.isAssignableFrom(UserViewModel::class.java))
            {
            return UserViewModel(repo) as T
        }else
            throw IllegalArgumentException("Not same type class")

    }

}