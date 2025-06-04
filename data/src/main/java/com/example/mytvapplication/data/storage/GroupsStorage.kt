package com.example.mytvapplication.data.storage

import com.example.mytvapplication.data.storage.model.Group


interface GroupsStorage {
    fun getGroups(): List<Group>
}