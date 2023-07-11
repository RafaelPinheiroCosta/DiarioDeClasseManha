package com.example.diariodeclasse.model

import com.example.diariodeclasse.R

class Aluno (
    val nome:String,
    val curso:String
){
    var foto:Int = R.drawable.login
    var faltas:Int = 0
    var nota:Int = 0
}