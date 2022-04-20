package com.example.myapplication.cocktails.game

class Game(i: Int) {

   var currentScore=0
    private set
    var highScore=i
    private set
    fun incrementScore(){
        currentScore++
            if (currentScore> highScore) highScore=currentScore
    }
}