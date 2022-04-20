package com.example.myapplication.cocktail

import com.example.myapplication.cocktails.game.Game
import org.junit.Assert
import org.junit.Test
import kotlin.test.assertEquals

class GameUnitTest {

    @Test
    fun WhenIncrementScore_shouldicrementCurrentScore() {
        val game = Game(10)
        game.incrementScore()
        assertEquals(1,game.currentScore)
    }

    @Test
    fun whenIncrementScore_aboveHighScore_should_incrementHighScore(){
        val game= Game(10)
        game.incrementScore()
        Assert.assertEquals(10,game.highScore)
    }
}