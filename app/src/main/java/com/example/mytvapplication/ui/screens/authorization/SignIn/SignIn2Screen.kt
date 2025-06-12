package com.example.mytvapplication.ui.screens.authorization.SignIn

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.tv.material3.Button
import androidx.tv.material3.Text
import com.example.mytvapplication.data.network.ApiRemoteDataSourceImpl
import com.example.mytvapplication.data.repository.AppRepositoryImpl
import com.example.mytvapplication.data.storage.LocalDataSourceImpl
import com.example.mytvapplication.domain.model.LoginParams
//import com.example.mytvapplication.data.repository.ApiRepositoryImpl
import com.example.mytvapplication.domain.usecase.LoginUseCase
import com.example.mytvapplication.ui.screens.Screens

@Composable
fun SignIn2Screen(
    rootNavController: NavHostController,
//    navController: NavHostController,
    viewModel: SignInViewModel = hiltViewModel()
) {
    Log.wtf("test", "start SignIn2Screen")

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val loginFlow by viewModel.loginFlow.collectAsState()
    val userIsLoggedIn by viewModel.userIsLoggedIn.collectAsState()

//    val remoteDataSource = ApiRemoteDataSourceImpl()
//    val localDataSource = LocalDataSourceImpl()
    val appRepository = AppRepositoryImpl(
//        remoteDataSource = remoteDataSource,
//        localDataSource = localDataSource
    )
    val loginUseCase = LoginUseCase(appRepository = appRepository)

    LaunchedEffect(userIsLoggedIn) {
        if (userIsLoggedIn == true) {
            rootNavController.navigate(Screens.Main.route) {
                popUpTo(Screens.Auth.route) {
                    inclusive = true
                    saveState = true
                }
            }
        }
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Button(
            onClick = {
//                Log.wtf("test", "HomeScreen Login onClick()")
////                val result = loginUseCase.execute()
////                if (result) {
////                    rootNavController.navigate(Screens.Main.route)
////                }
//
//                val result = loginUseCase.execute()
//                if (result) {
//                    rootNavController.navigate(Screens.Main.route)
//                }
                viewModel.login(LoginParams("", ""))
            }
        ) {
            Text(
                text = "Login",
                color = Color.White
            )
        }
    }
}