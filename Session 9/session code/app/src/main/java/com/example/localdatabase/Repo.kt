package com.example.localdatabase

class Repo(private val userDAO: UserDAO) {


    suspend fun insertUser(user: User)
    {
        userDAO.insertUser(user)
    }
}