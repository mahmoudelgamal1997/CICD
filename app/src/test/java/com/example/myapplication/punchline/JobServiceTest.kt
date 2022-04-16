package com.example.myapplication.punchline

import Joke
import JokeService
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Rule
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.test.assertEquals

class JobServiceTestUsingMockWebServer {

    @get:Rule
    val mockWebServer = MockWebServer()

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    private val jokeService by lazy {
        retrofit.create(JokeService::class.java)
    }

    @Test
    fun getRandomJokeEmitsJoke(){

        mockWebServer.enqueue(
            MockResponse().setBody(testJson)
                .setResponseCode(200))
        //actual
        val testObserve = jokeService.getRandomJoke().test()
        testObserve.assertNoErrors()
        assertEquals("/random_joke.json",mockWebServer.takeRequest().path)

    }
    //expected
    private val testJson="""{"id":5,"joke":"jokkkkkkke"}"""
}