package com.example.mytvapplication.data.storage

import com.example.mytvapplication.data.storage.model.Channel


interface ChannelsStorage {
    fun getChannels(): List<Channel>
}