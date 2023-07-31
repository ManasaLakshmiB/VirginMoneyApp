package com.example.virginMoneyapp.ui.viewmodel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.virginMoneyapp.data.model.people.PeopleItemModel
import com.example.virginMoneyapp.data.model.people.PeopleModel
import com.example.virginMoneyapp.data.remote.ApiCall
import com.example.virginMoneyapp.data.repository.Repo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PeopleViewModel @Inject constructor

    (private val repo: Repo) : ViewModel() {

    private val listOfPeople = MutableStateFlow<List<PeopleItemModel>>(emptyList())

    val peoples: StateFlow<List<PeopleItemModel>> = listOfPeople

    init {
        fetchPeopleData()

    }




    fun fetchPeopleData() {
        viewModelScope.launch {
            try {
                val peopleList = repo.getPeopleModel()

                listOfPeople.value = peopleList

            } catch (e: Exception) {
                // Handle API error
                e.printStackTrace()

            }
        }
    }
}
