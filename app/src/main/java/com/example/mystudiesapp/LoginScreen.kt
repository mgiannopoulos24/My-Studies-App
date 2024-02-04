package com.example.mystudiesapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mystudiesapp.LoginForm

class LoginScreen : ComponentActivity() {
    // ...

    @Composable
    fun LoginContent() {
        // ... existing code ...

        Button(
            onClick = {
                startActivity(Intent(this@LoginScreen, LoginForm::class.java))
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text("Open Login Form", fontSize = 20.sp)
        }

        // ... existing code ...
    }
}
