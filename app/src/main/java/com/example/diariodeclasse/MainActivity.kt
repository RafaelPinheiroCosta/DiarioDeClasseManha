package com.example.diariodeclasse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.diariodeclasse.telas.telaListaDeAlunos.TelaListaAlunos
import com.example.diariodeclasse.telas.telaLogin.TelaLogin
import com.example.diariodeclasse.ui.theme.DiarioDeClasseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiarioDeClasseTheme {
                AppDiarioDeClasse()
            }
        }
    }
}
@Composable
fun AppDiarioDeClasse(){

    val controleDeNavegacao = rememberNavController()

    NavHost(
        navController = controleDeNavegacao,
        startDestination = "telaLogin"
    ){
        composable(
            route = "telaLogin"
        ){
            TelaLogin(controleDeNavegacao)
        }
        composable(
            route = "telaListaAlunos"
        ){
            TelaListaAlunos(controleDeNavegacao)
        }
    }

}

