package com.example.mytvapplication.data.repository

import com.example.mytvapplication.domain.model.Genre
import com.example.mytvapplication.domain.model.Program
import com.example.mytvapplication.domain.repository.EPGRepository

class EPGRepositoryImpl: EPGRepository {
    override fun getEpg(): List<Program> {
        return listOf(
            Program(epgStart = 1000, epgEnd = 1100, name = "Program_name_1", description = ""),
            Program(epgStart = 1100, epgEnd = 1200, name = "Program_name_2", description = ""),
            Program(epgStart = 1200, epgEnd = 1300, name = "Program_name_3", description = ""),
            Program(epgStart = 1300, epgEnd = 1400, name = "Program_name_4", description = ""),
            Program(epgStart = 1400, epgEnd = 1500, name = "Program_name_5", description = ""),
            Program(epgStart = 1500, epgEnd = 1600, name = "Program_name_6", description = ""),
            Program(epgStart = 1600, epgEnd = 1700, name = "Program_name_7", description = ""),
            Program(epgStart = 1700, epgEnd = 1800, name = "Program_name_8", description = ""),
            Program(epgStart = 1800, epgEnd = 1900, name = "Program_name_9", description = ""),
        )
    }
}