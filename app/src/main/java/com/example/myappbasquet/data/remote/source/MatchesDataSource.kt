package com.example.myappbasquet.data.remote.source

import com.example.myappbasquet.data.remote.firestore.MatchesRemoteFire
import com.example.myappbasquet.data.remote.model.MatchesEntry
import javax.inject.Inject
import javax.inject.Singleton


class MatchesDataSource @Inject constructor(private val matchesRemoteFire: MatchesRemoteFire) {
    suspend fun getMatchesFire(user_name:String): List<MatchesEntry>{
        return matchesRemoteFire.getMatchesFire(user_name)
    }
}