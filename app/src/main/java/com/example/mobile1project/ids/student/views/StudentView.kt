package com.example.mobile1project.ids.student.views

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.example.mobile1project.ids.student.viewmodels.StudentViewModel
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun StudentList(viewModel: StudentViewModel) {
    val students = viewModel.students.collectAsState()
    LazyColumn(modifier = Modifier.padding(16.dp)) {
        items(students.value) { student ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Text(
                    text = student.name,
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}