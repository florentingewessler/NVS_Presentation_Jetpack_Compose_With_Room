package com.example.nvs_student_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.setContent
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.ui.tooling.preview.Preview
import com.example.nvs_student_app.data.StudentViewModel
import com.example.nvs_student_app.ui.NVS_Student_AppTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val studentViewModel: StudentViewModel =
            ViewModelProvider(this).get(StudentViewModel::class.java)

        setContent {
            NVS_Student_AppTheme {
                ScreenNavigator(studentViewModel)
            }
        }
    }
}

@Composable
fun ScreenNavigator(studentViewModel: StudentViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "student_list") {
        composable("student_list") {
            NvsStudentScaffold(studentViewModel, navController)
        }
        composable("enter_data") {
            EnterDataView(studentViewModel, navController)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NVS_Student_AppTheme {
        // Greeting("Android")
    }
}

