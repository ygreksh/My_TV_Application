package com.example.mytvapplication.ui.screens.authorization

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.tv.material3.Button
import androidx.tv.material3.Text
import com.example.mytvapplication.data.network.ApiRemoteDataSourceImpl
import com.example.mytvapplication.data.network.RemoteDataSource
import com.example.mytvapplication.data.repository.AppRepositoryImpl
import com.example.mytvapplication.data.storage.LocalDataSourceImpl
//import com.example.mytvapplication.data.repository.ApiRepositoryImpl
import com.example.mytvapplication.domain.repository.UserRepository
import com.example.mytvapplication.domain.usecase.GetGroupsUseCase
import com.example.mytvapplication.domain.usecase.LoginUseCase
import com.example.mytvapplication.ui.screens.Screens

@Composable
fun SignIn2Screen(
    rootNavController: NavHostController,
    navController: NavHostController
) {
    Log.wtf("test", "start SignIn2Screen")

    val remoteDataSource = ApiRemoteDataSourceImpl()
    val localDataSource = LocalDataSourceImpl()
    val appRepository = AppRepositoryImpl(
        remoteDataSource = remoteDataSource,
        localDataSource = localDataSource
    )
    val loginUseCase = LoginUseCase(appRepository = appRepository)

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Button(
            onClick = {
                Log.wtf("test", "HomeScreen Login onClick()")
//                rootNavController.navigate(Screens.Main.route)
                val result = loginUseCase.execute()
                if (result) {
                    rootNavController.navigate(Screens.Main.route)
                }
            }
        ) {
            Text(
                text = "Login",
                color = Color.White
            )
        }
    }
}