package com.example.mytvapplication.data.repository

import com.example.mytvapplication.data.network.RemoteDataSource
import com.example.mytvapplication.data.storage.LocalDataSource
import com.example.mytvapplication.domain.model.Channel
import com.example.mytvapplication.domain.model.Group
import com.example.mytvapplication.domain.model.LoginParams
import com.example.mytvapplication.domain.model.Movie
import com.example.mytvapplication.domain.repository.AppRepository

class AppRepositoryImpl(
    val localDataSource: LocalDataSource,
    val remoteDataSource: RemoteDataSource
) : AppRepository {
    override fun login(params: LoginParams): Boolean {
        val result = remoteDataSource.login(params = params)
        return result
    }

    override fun getGroups(): List<Group> {
        val localResult = localDataSource.getGroups()
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