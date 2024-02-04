package com.example.mystudiesapp

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.mystudiesapp.databinding.ActivityLoginScreenBinding


class LoginForm : AppCompatActivity() {
    private lateinit var loginScreenBinding: ActivityLoginScreenBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate the parent layout used in LoginScreen.kt
        loginScreenBinding = ActivityLoginScreenBinding.inflate(layoutInflater)
        val view = loginScreenBinding.root
        setContentView(view)

        // Access views from the LoginScreen layout
        val usernameEditText: EditText = loginScreenBinding.usernameEditText
        val passwordEditText: EditText = loginScreenBinding.passwordEditText

        // You can now use usernameEditText and passwordEditText as needed
        // ...

        // For example, set hint for username and password
        usernameEditText.hint = "Username"
        passwordEditText.hint = "Password"
    }
}
