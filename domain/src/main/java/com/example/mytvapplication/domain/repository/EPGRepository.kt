package com.example.mytvapplication.domain.repository

import com.example.mytvapplication.domain.model.Program

interface EPGRepository {
    fun getEpg(): List<Program>
}