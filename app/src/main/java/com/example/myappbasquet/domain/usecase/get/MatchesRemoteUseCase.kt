package com.example.myappbasquet.domain.usecase.get

import com.example.myappbasquet.core.coroutines.ResultUseCase
import com.example.myappbasquet.data.remote.model.MatchesEntry
import com.example.myappbasquet.data.repository.MatchesRepository
import kotlinx.coroutines.Dispatchers

class MatchesRemoteUseCase (private val repository: MatchesRepository
): ResultUseCase<String, List<MatchesEntry>>(
    backgroundContext = Dispatchers.IO,
    foregroundContext = Dispatchers.Main
) {
    override suspend fun executeOnBackground(params: String): List<MatchesEntry>? {
        return repository.getMatchesFire(params)
    }

}