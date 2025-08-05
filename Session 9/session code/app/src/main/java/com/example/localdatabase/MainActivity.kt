package com.example.localdatabase

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider


class MainActivity : AppCompatActivity() {
    //ui
    lateinit var username_plain: EditText
    lateinit var email_plain: EditText
    lateinit var insert_buttton:Button
    //database
    lateinit var dp:AppDatabase
    lateinit var userDAO: UserDAO
    lateinit var repo: Repo
    lateinit var factory:UserViewModelFActory
    lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onStart() {
        super.onStart()

    }
    override fun onResume() {
        super.onResume()
        username_plain=findViewById(R.id.username)
        email_plain=findViewById(R.id.email)
        insert_buttton=findViewById(R.id.button)
        //database
        dp=AppDatabase.getDatabase(this)
        userDAO=dp.getUserDao()
        repo=Repo(userDAO)
        factory=UserViewModelFActory(repo)
        userViewModel=ViewModelProvider(this,factory).get(UserViewModel::class.java)
        // logic
        insert_buttton.setOnClickListener {
            var user=User(name = username_plain.text.toString(), email = email_plain.text.toString())
            userViewModel.insertUser(user)
            username_plain.text=null
            email_plain.text=null

        }
    }
}