package com.example.nvs_student_app

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawShadow
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import com.example.nvs_student_app.data.Student
import com.example.nvs_student_app.data.StudentViewModel

@Composable
fun EnterDataView(studentViewModel: StudentViewModel, navController: NavHostController) {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    Scaffold(scaffoldState = scaffoldState, topBar = {
        TopAppBar() {
            Text("Dateneingabe", modifier = Modifier.padding(16.dp))
        }
    }, bodyContent = {
        Box(alignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                val modifier = Modifier.padding(vertical = 4.dp)

                val usernameState = remember { mutableStateOf(TextFieldValue()) }
                TextField(
                    value = usernameState.value,
                    onValueChange = { usernameState.value = it },
                    modifier = modifier,
                    placeholder = { Text("Vorname") }
                )

                val lastnameState = remember { mutableStateOf(TextFieldValue()) }

                TextField(
                    value = lastnameState.value,
                    onValueChange = { lastnameState.value = it },
                    modifier = modifier,
                    placeholder = { Text("Nachname") },
                )

                val gradeState = remember { mutableStateOf(TextFieldValue()) }
                TextField(
                    value = gradeState.value,
                    onValueChange = { gradeState.value = it },
                    modifier = modifier,
                    placeholder = { Text("Note") },
                )

                Button(
                    onClick = {
                        val student = Student(
                            0,
                            usernameState.value.text,
                            lastnameState.value.text,
                            Integer.parseInt(gradeState.value.text)
                        )

                        studentViewModel.addStudent(student)

                        // navigate back
                        navController.navigate("student_list")
                    },
                    modifier = modifier.then(Modifier.drawShadow(elevation = 10.dp))
                ) {
                    Text("Speichern")
                }
            }
        }
    })
}