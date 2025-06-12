package com.example.mytvapplication.data.repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.mytvapplication.data.network.ApiRemoteDataSourceImpl
import com.example.mytvapplication.data.network.RemoteDataSource
import com.example.mytvapplication.data.storage.LocalDataSource
import com.example.mytvapplication.data.storage.LocalDataSourceImpl
import com.example.mytvapplication.domain.model.Channel
import com.example.mytvapplication.domain.model.Group
import com.example.mytvapplication.domain.model.LoginParams
import com.example.mytvapplication.domain.model.Movie
import com.example.mytvapplication.domain.repository.ApiResult
import com.example.mytvapplication.domain.repository.AppRepository
import kotlinx.coroutines.flow.Flow
import java.time.LocalDateTime
import java.util.Calendar
import javax.inject.Inject

class AppRepositoryImpl @Inject constructor(
//    val localDataSource: LocalDataSource,
//    val remoteDataSource: RemoteDataSource
) : AppRepository {
    val localDataSource = LocalDataSourceImpl()
    val remoteDataSource = ApiRemoteDataSourceImpl()

    override suspend fun login(params: LoginParams): Flow<ApiResult<Boolean>> {
        val result = remoteDataSource.login(params = params)
        return result
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun getGroups(): List<Group> {
        val localResult = localDataSource.getGroups()
//        val now = LocalDateTime.now()
//        val seconds = now.second
//        val calendar = Calendar.getInstance()
//        val milliseconds = calendar.timeInMillis

        if (localResult.isNotEmpty()) {
            return localResult
            }
        else {
            val remoteResult = remoteDataSource.getGroups()
            return remoteResult
        }
    }

    override fun getChannels(): List<Channel> {
        val localResult = localDataSource.getChannels()
        if (localResult.isNotEmpty()) {
            return localResult
        }
        else {
            val remoteResult = remoteDataSource.getChannels()
            return remoteResult
        }
    }

    override fun getLastMovies(): List<Movie> {
        val localResult = localDataSource.getLastMovies()
        if (localResult.isNotEmpty()) {
            return localResult
        }
        else {
            val remoteResult = remoteDataSource.getLastMovies()
            return remoteResult
        }
    }
}