package com.example.virginMoneyapp.ui.screens


import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.virginMoneyapp.ui.viewmodel.PeopleViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
                 personId: String,
                 viewModel: PeopleViewModel,
                 onBack:() -> Unit

) {
    val people by viewModel.peoples.collectAsState()
    val person = people.find { it.id == personId }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "PeopleDetails") },
                colors = TopAppBarDefaults.smallTopAppBarColors(Color.Gray),
                navigationIcon = {
                    IconButton(onClick = { onBack() }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = null)
                    }
                }
            )
        }
    ){
        Column(
           horizontalAlignment = Alignment.CenterHorizontally,
          // verticalArrangement = Arrangement.SpaceAround,
           modifier = Modifier
               .fillMaxSize()
        ) {
            AsyncImage(model = person?.avatar,
                contentDescription = "person image",
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .heightIn(min = 200.dp, max = 300.dp)
                )
            person?.let {
                Text(text = "Id: ${person.id}")
                Text(text = "Name: ${person.firstName}")
                Text(text = "Email: ${person.email}")

                //Text(text = it.firstName ?: "no name here", fontSize = 24.sp)

            }
        }
    }


}