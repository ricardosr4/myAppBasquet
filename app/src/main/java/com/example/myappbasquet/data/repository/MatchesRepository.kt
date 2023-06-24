package com.example.myappbasquet.data.repository

import com.example.myappbasquet.data.remote.model.MatchesEntry
import com.example.myappbasquet.data.remote.source.MatchesDataSource

open class MatchesRepository(private val matchesDataSource: MatchesDataSource) {
    suspend fun getMatchesFire(user_name:String): List<MatchesEntry>{
        return matchesDataSource.getMatchesFire(user_name)
    }
}