package com.example.mystudiesapp

import android.content.Intent
import android.net.Uri
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.example.mystudiesapp.ui.theme.MyStudiesAppTheme

class Login_Form : ComponentActivity() {
    private val auth: FirebaseAuth by lazy { Firebase.auth }

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyStudiesAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var email by remember { mutableStateOf("") }
                    var password by remember { mutableStateOf("") }
                    var errorMessage by remember { mutableStateOf<String?>(null) }

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ekpa_logo),
                            contentDescription = "EKPA Logo",
                            modifier = Modifier
                                .height(150.dp)
                                .width(450.dp)
                                .clip(MaterialTheme.shapes.medium)
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        BasicTextField(
                            value = email,
                            onValueChange = { email = it },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Email,
                                imeAction = ImeAction.Next
                            ),
                            singleLine = true,
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(MaterialTheme.colorScheme.background)
                                .clip(MaterialTheme.shapes.medium)
                                .padding(8.dp)
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        BasicTextField(
                            value = password,
                            onValueChange = { password = it },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Password,
                                imeAction = ImeAction.Done
                            ),
                            singleLine = true,
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(MaterialTheme.colorScheme.background)
                                .clip(MaterialTheme.shapes.medium)
                                .padding(8.dp)
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        val context = LocalContext.current

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 8.dp),
                            horizontalArrangement = Arrangement.Start
                        ) {
                            Text(
                                text = "Ξεχάσατε τον κωδικό σας?",
                                modifier = Modifier.clickable {
                                    val intent =
                                        Intent(
                                            Intent.ACTION_VIEW,
                                            Uri.parse("http://www.noc.uoa.gr/diaxeirish-logariasmoy.html")
                                        )
                                    context.startActivity(intent)
                                },
                                style = MaterialTheme.typography.body2
                            )
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        Button(
                            onClick = {
                                signInWithEmailAndPassword(email, password)
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                        ) {
                            Text("Είσοδος", fontSize = 20.sp)
                        }

                        errorMessage?.let {
                            Text(
                                text = it,
                                color = MaterialTheme.colorScheme.error,
                                fontSize = 14.sp,
                                modifier = Modifier.padding(top = 8.dp)
                            )
                        }
                    }
                }
            }
        }
    }

    private fun signInWithEmailAndPassword(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, handle success case
                    val userEmail = auth.currentUser?.email
                    when (userEmail) {
                        "lakisla@di.uoa.gr" -> navigateTo("/MainStud")
                        "prof1@di.uoa.gr" -> navigateTo("/MainProf")
                        "reg1@di.uoa.gr" -> navigateTo("/MainReg")
                        else -> {
                            // Handle other cases or show an error message
                            errorMessage = "Invalid user email"
                        }
                    }
                } else {
                    // If sign in fails, display a message to the user.
                    errorMessage = "Authentication failed. Please try again."
                }
            }
    }

    private fun navigateTo(destination: String) {
        // Navigate to the specified destination
        // You may need to implement your own navigation logic based on your project setup
    }
}
