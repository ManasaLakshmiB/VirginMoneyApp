package com.example.virginMoneyapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.virginMoneyapp.data.model.people.PeopleItemModel
import com.example.virginMoneyapp.data.model.people.PeopleModel
import com.example.virginMoneyapp.data.model.rooms.RoomItemModel
import com.example.virginMoneyapp.data.model.rooms.RoomModel
import com.example.virginMoneyapp.data.remote.ApiCall
import com.example.virginMoneyapp.data.repository.Repo
import com.example.virginMoneyapp.data.repository.RepoImpl
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNull
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import net.bytebuddy.agent.VirtualMachine.ForOpenJ9.Dispatcher
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class RepoTest {

    private val testDispatcher = StandardTestDispatcher()

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()
    lateinit var repo: Repo

    @Mock
    lateinit var apicall:ApiCall

    @Before
    fun startup(){
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(testDispatcher)

        repo = RepoImpl(apicall)
    }

    @Test
    fun getPeopleModel_Success() = runTest{

        val mockresponse = listOf(
            PeopleItemModel(
                firstName = "Hello",
                id = "1",
                )

        )
        val people_Samplelist = PeopleModel()
        people_Samplelist.addAll(mockresponse)

        `when`(apicall.getPeopleModel()).thenReturn(people_Samplelist)

        val result = repo.getPeopleModel()

        assertEquals(result.get(0).firstName,mockresponse.get(0).firstName)
        assertEquals(result.get(0).id,mockresponse.get(0).id)

    }
    @Test
    fun getPeopleModel_Failure() = runTest{
        val mockResponse = null

        `when`(apicall.getPeopleModel()).thenReturn(mockResponse)

        val result = repo.getPeopleModel()

        assertNull(result)
    }

    @Test
    fun getRoomModel_Success() = runTest{

        val mockresponse = listOf(
            RoomItemModel(
                id ="1",
                maxOccupancy =1

            )

        )
        val Room_Samplelist = RoomModel()
        Room_Samplelist.addAll(mockresponse)

        `when`(apicall.getRoomsModel()).thenReturn(Room_Samplelist)

        val result = repo.getRoomsModel()

        assertEquals(result.get(0).isOccupied,mockresponse.get(0).isOccupied)
        assertEquals(result.get(0).id,mockresponse.get(0).id)

    }
    @Test
    fun getRoomModel_Failure() = runTest{
        val mockResponse = null

        `when`(apicall.getRoomsModel()).thenReturn(mockResponse)

        val result = repo.getRoomsModel()

        assertNull(result)
    }


}