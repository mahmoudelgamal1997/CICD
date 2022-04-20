package com.example.myapplication.cocktail

import com.example.myapplication.cocktails.game.Question
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class QuestingUnitTests {

    private lateinit var question: Question
    @Before
    fun setUp(){
         question = Question("CORRECT","INCORRECT")

    }
    @Test
    fun whenCreateQuestion_shouldnothave_answeredOptions(){
        Assert.assertNull(question.answerdOption)
    }

    @Test
    fun when_answer_should_equal_answerd_option(){
        val result=question.answer("CORRECT")
        Assert.assertTrue(result)
    }

}