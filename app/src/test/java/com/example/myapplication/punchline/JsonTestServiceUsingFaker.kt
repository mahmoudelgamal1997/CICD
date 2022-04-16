package com.example.myapplication.punchline

import Joke
import JokeService
import com.github.javafaker.Faker
import com.raywenderlich.android.punchline.RepositoryImpl
import io.reactivex.Single
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import kotlin.test.assertEquals

class JsonTestServiceUsingFaker
{
    val jokeService:JokeService = mock()
    val repository=RepositoryImpl(jokeService)
    val faker= Faker()

    @Test
    fun getJokeForTest(){
        val joke=Joke(
            joke = faker.lorem().sentence()
            ,id = faker.idNumber().valid(),
        )
    whenever(jokeService.getRandomJoke()).thenReturn(Single.just(joke))
   val testObserve = repository.getJoke().test()
   testObserve.assertValue(joke)

    }

}