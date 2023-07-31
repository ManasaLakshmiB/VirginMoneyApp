package com.example.virginMoneyapp.data.repository

import com.example.virginMoneyapp.data.remote.ApiCall
import javax.inject.Inject

class RepoImpl @Inject constructor(

    val dataCall: ApiCall

) : Repo {
    override suspend fun getPeopleModel() = dataCall.getPeopleModel()

    override suspend fun getRoomsModel() = dataCall.getRoomsModel()
}