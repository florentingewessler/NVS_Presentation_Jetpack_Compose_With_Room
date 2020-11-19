package com.example.nvs_student_app

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import com.example.nvs_student_app.data.Student
import com.example.nvs_student_app.data.StudentViewModel

@Composable
fun NvsStudentScaffold(studentViewModel: StudentViewModel, navController: NavHostController) {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar() {
                Text("NVS Student App", modifier = Modifier.padding(16.dp))
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate("enter_data") }) {
                Text("+")
            }
        },
        drawerContent = {
            Box(modifier = Modifier.padding(16.dp)) {
                Button(
                    onClick = { studentViewModel.clearStudents() },
                    Modifier.background(Color.Green)
                ) {
                    Text("Daten löschen")
                }
            }
        },
        bodyContent = { StudentListView(studentViewModel = studentViewModel) },
        backgroundColor = MaterialTheme.colors.background
    )
}

@Composable
fun StudentListView(studentViewModel: StudentViewModel) {

    LazyColumnFor(studentViewModel.students!!) { item ->
        StudentItem(item)
    }
}

@Composable
fun StudentItem(student: Student) {
    Card(
        shape = RoundedCornerShape(8.dp),
        backgroundColor = MaterialTheme.colors.surface,
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        elevation = 10.dp
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row() {
                Text(student.firstname)
                Text(" ")
                Text(student.lastName)
            }
            Text("Note: " + student.grade)
        }
    }
}