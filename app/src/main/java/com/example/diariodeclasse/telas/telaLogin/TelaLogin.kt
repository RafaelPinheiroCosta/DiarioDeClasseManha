package com.example.diariodeclasse.telas.telaLogin

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.diariodeclasse.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaLogin(
    controleDeNavegacao: NavHostController,
    telaLoginViewModel: TelaLoginViewModel = viewModel()
) {

    val telaLoginUiState by telaLoginViewModel.telaLoginUiState.collectAsState()



    Card() {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(20.dp)
        ) {
            Text(
                text = "Login",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(20.dp))
            Image(
                painter = painterResource(id = R.drawable.login),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(200.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(
                value = telaLoginViewModel.login,
                onValueChange = {telaLoginViewModel.updateLogin(it)},
                label = { Text(text = "Login")},
                isError = telaLoginUiState.erroLogin
            )
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(
                value = telaLoginViewModel.senha,
                onValueChange = {telaLoginViewModel.updateSenha(it)},
                label = { Text(text = "Senha")},
                isError = telaLoginUiState.erroLogin
            )
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = {
                    telaLoginViewModel.logarUsuario()
                }
            ) {
                Text(text = "Entrar")
            }
            if(telaLoginUiState.logado) {
                controleDeNavegacao.navigate("telaListaAlunos")
            }

        }
    }
}