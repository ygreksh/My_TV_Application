package com.example.mytvapplication.ui

import com.example.mytvapplication.MainActivityViewModel
import com.example.mytvapplication.data.repository.AppRepositoryImpl
import com.example.mytvapplication.domain.repository.AppRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun providesAppRepository(impl: AppRepositoryImpl): AppRepository = impl

    @Singleton
    @Provides
    fun provideMainActivityViewModel(
    ): MainActivityViewModel {
        return MainActivityViewModel()
    }
}