package com.example.virginMoneyapp.ui.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.virginMoneyapp.data.model.rooms.RoomItemModel
import com.example.virginMoneyapp.ui.viewmodel.RoomViewModel

@Composable
fun Rooms(viewModel: RoomViewModel) {

    val room by viewModel.rooms.collectAsState()

    LazyColumn {
        items(room) { roomslist ->
            Roomslist(roomslist)
        }
    }
}


@Composable
fun Roomslist(roomslist: RoomItemModel) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(14.dp)
                .fillMaxSize()
        )
        {
            Text(text = "Id: ${roomslist.id}", fontSize = 24.sp)
            Text(text = "Occupency:${roomslist.maxOccupancy}", fontSize = 24.sp)

        }
       }
    }
