package com.example.myapplication.punchline

import Joke
import JokeService
import com.raywenderlich.android.punchline.RepositoryImpl
import io.reactivex.Single
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class JokeServiceTestMockingService {
    private val jokeService: JokeService = mock()
    private val repository=RepositoryImpl(jokeService)

    @Test
    fun  getRandomJokeEmitsJoke(){
        val joke = Joke("5","jokkkkke")
        whenever(jokeService.getRandomJoke()).thenReturn(Single.just(joke))
        val testObserve=repository.getJoke().test()
        testObserve.assertValue(joke)
    }
}