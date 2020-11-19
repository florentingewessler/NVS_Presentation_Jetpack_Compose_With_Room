package com.example.composemeal

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ContentColorAmbient
import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Providers
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                LoginForm()
            }
        }
    }

    @Preview
    @Composable
    fun PhotographerCardPreview() {
        MaterialTheme {
            BoxLayout()
        }
    }

    @Composable
    fun BoxLayout() {
        Box(alignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
            Box(modifier = Modifier
                    .background(Color.Blue)
                    .size(200.dp), alignment = Alignment.TopEnd) {
                Box(modifier = Modifier.background(Color.Green).size(25.dp))
            }
            Box(modifier = Modifier
                    .background(Color.Red)
                    .size(100.dp), alignment = Alignment.BottomStart) {
                Box(modifier = Modifier.background(Color.Yellow).size(25.dp))
            }
        }
    }

    @Preview
    @Composable
    fun LoginFormPreview() {
        LoginForm()
    }

    @Composable
    fun LoginForm() {
        Box(alignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                val modifier = Modifier.padding(vertical = 4.dp)

                val usernameState = remember { mutableStateOf(TextFieldValue()) }
                TextField(
                        value = usernameState.value,
                        onValueChange = { usernameState.value = it },
                        modifier = modifier,
                        placeholder = { Text("Username") }
                )

                val passwordState = remember { mutableStateOf(TextFieldValue()) }
                TextField(value = passwordState.value,
                        onValueChange = { passwordState.value = it },
                        modifier = modifier,
                        placeholder = { Text("Password") },
                        keyboardType = KeyboardType.Password
                )

                Button(
                        onClick = {
                            Log.i("test", "Username: ${usernameState.value} -" +
                                    " Password: ${usernameState.value}")
                        },
                        modifier = modifier.then(Modifier.drawShadow(elevation = 10.dp))) {
                    Text("Login")
                }
            }
        }
    }


}
