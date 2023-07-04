package com.example.myappbasquet.domain.usecase.get

import com.example.myappbasquet.data.remote.model.MatchesEntry
import com.example.myappbasquet.data.repository.MatchesRepository
import javax.inject.Inject


class MatchesRemoteUseCase @Inject constructor (private val repository: MatchesRepository )  {
     suspend fun getMatchesFire(params: String): List<MatchesEntry>? {
        return repository.getMatchesFire(params)
    }

}