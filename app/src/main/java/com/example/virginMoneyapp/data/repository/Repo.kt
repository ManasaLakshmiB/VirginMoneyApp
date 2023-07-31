package com.example.virginMoneyapp.data.repository

import com.example.virginMoneyapp.data.model.people.PeopleModel
import com.example.virginMoneyapp.data.model.rooms.RoomModel

interface Repo {

    suspend fun getPeopleModel(): PeopleModel

    suspend fun getRoomsModel(): RoomModel
}