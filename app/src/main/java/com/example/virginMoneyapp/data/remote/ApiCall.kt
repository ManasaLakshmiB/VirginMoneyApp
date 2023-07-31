package com.example.virginMoneyapp.data.remote

import com.example.virginMoneyapp.data.model.people.PeopleModel
import com.example.virginMoneyapp.data.model.rooms.RoomModel
import retrofit2.http.GET

interface ApiCall {

    @GET(ApiDetail.END_POINT)
    suspend fun getPeopleModel(): PeopleModel

    @GET(ApiDetail.ROOM_URL)
    suspend fun getRoomsModel(): RoomModel

}