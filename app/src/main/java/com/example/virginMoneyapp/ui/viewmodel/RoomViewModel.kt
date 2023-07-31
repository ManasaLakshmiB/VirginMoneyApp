package com.example.virginMoneyapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.virginMoneyapp.data.model.people.PeopleItemModel
import com.example.virginMoneyapp.data.model.rooms.RoomItemModel
import com.example.virginMoneyapp.data.repository.Repo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RoomViewModel @Inject constructor

    (private val repo: Repo) : ViewModel() {

    private val listOfRoom = MutableStateFlow<List<RoomItemModel>>(emptyList())

    val rooms: StateFlow<List<RoomItemModel>> = listOfRoom

    init {
        fetchPeopleData()
    }




    fun fetchPeopleData() {
        viewModelScope.launch {
            try {
                val roomsdata = repo.getRoomsModel()

                listOfRoom.value = roomsdata

            } catch (e: Exception) {
                // Handle API error
                e.printStackTrace()

            }
        }
    }
}
