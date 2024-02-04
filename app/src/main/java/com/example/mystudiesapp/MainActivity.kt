package com.example.mystudiesapp
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.mystudiesapp.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.example.mystudiesapp.LoginScreen


class MainActivity : ComponentActivity() {
    private val auth: FirebaseAuth by lazy { Firebase.auth }
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate the layout using View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Start the LoginScreen activity when the MainActivity is created
        startActivity(Intent(this, LoginScreen::class.java))
        finish() // Optional: Finish the MainActivity to prevent going back to it from the LoginScreen
    }
}
