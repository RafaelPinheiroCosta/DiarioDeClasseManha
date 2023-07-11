package com.example.diariodeclasse.telas.telaLogin

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class TelaLoginViewModel : ViewModel(){

    private val _telaLoginUiState = MutableStateFlow(TelaLoginUiState())
    val telaLoginUiState: StateFlow<TelaLoginUiState> = _telaLoginUiState.asStateFlow()

    private var auth: FirebaseAuth = Firebase.auth

    var login by mutableStateOf("")

    var senha by mutableStateOf("")

    fun updateLogin(login:String){
        this.login = login
        updateTelaLogin(false)
    }

    fun updateSenha(senha:String){
        this.senha = senha
        updateTelaLogin(false)
    }

    fun updateTelaLogin(erroLogin:Boolean=false, logado:Boolean=false){

        _telaLoginUiState.update { currentState ->
            currentState.copy(
                erroLogin=erroLogin,
                logado = logado
            )
        }

    }

    fun limpaCampos(){
        this.login = ""
        this.senha = ""
    }

    fun logarUsuario(){

        if(login.isEmpty() || senha.isEmpty()){
            updateTelaLogin(
                erroLogin = true
            )
            return
        }

        val task = this.auth.signInWithEmailAndPassword(login,senha)

        task.addOnSuccessListener {
            updateTelaLogin(logado = true, erroLogin = false)
            limpaCampos()
        }



    }

}