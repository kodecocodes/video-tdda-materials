package com.raywenderlich.android.cocktails.game.model

class Game {
    var currentScore = 0
        private set

    fun incrementScore(){
        currentScore++
    }
}