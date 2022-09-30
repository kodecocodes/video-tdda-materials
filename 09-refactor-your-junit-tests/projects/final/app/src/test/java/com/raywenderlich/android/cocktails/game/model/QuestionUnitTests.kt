package com.raywenderlich.android.cocktails.game.model

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class QuestionUnitTests {

    private lateinit var question: Question

    @Before
    fun setup() {
        val question = Question("CORRECT", "INCORRECT")
    }

    @Test
    fun whenCreatingQuestion_shouldNotHaveAnsweredOption(){
        Assert.assertNull(question.answeredOption)
    }

    @Test
    fun whenAnswering_shouldHaveAnsweredOption(){
        question.answer("INCORRECT")
        Assert.assertEquals("INCORRECT", question.answeredOption)
    }

    @Test
    fun whenAnswering_withCorrectOption_shouldReturnTrue(){
        val result = question.answer("CORRECT")
        Assert.assertTrue(result)
    }

    @Test
    fun whenAnswering_withInCorrectOption_shouldReturnTrue(){
        val result = question.answer("CORRECT")
        Assert.assertTrue(result)
    }
}