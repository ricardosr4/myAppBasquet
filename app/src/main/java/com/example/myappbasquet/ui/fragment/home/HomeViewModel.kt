package com.example.myappbasquet.ui.fragment.home

import androidx.lifecycle.ViewModel
import com.example.myappbasquet.core.extension.LiveResult
import com.example.myappbasquet.data.remote.model.MatchesEntry
import com.example.myappbasquet.domain.usecase.get.MatchesRemoteUseCase

class HomeViewModel (
    private val getMatchesRemoteUseCase : MatchesRemoteUseCase
    ): ViewModel(){
    val getMatchesLiveData = LiveResult<List<MatchesEntry>>()

    // esta funcion recibe el nombre de usuario de la vista y enviar este valor al caso de de uso
    fun getMatches(user_name:String){
        getMatchesRemoteUseCase.execute(liveData = getMatchesLiveData, params = user_name)
    }
}