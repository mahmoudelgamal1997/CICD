package com.example.myapplication.cocktails.game

data class Question(
    val correctOption:String,
    val incorrectOption:String
) {
    var answerdOption:String ? =null
    private set

    fun answer(answer:String):Boolean{
        answerdOption=answer
     return correctOption==answerdOption
    }

}