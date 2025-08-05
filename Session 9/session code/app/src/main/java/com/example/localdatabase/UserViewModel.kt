package com.example.localdatabase

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class UserViewModel(private val repo: Repo):ViewModel() {

    fun insertUser(user: User)
    {
        viewModelScope.launch(Dispatchers.IO) {

            repo.insertUser(user)
        }
    }
}