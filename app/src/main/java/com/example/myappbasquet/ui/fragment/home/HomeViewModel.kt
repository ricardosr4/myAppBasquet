package com.example.myappbasquet.ui.fragment.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myappbasquet.data.remote.model.MatchesEntry
import com.example.myappbasquet.domain.usecase.get.MatchesRemoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getMatchesRemoteUseCase: MatchesRemoteUseCase) :
    ViewModel() {

    val matchesModel = MutableLiveData<MatchesEntry>()
    val isloading = MutableLiveData<Boolean>()

    fun getMatches(user_name: String) {
        viewModelScope.launch {
            isloading.postValue(true)
            val result = getMatchesRemoteUseCase.getMatchesFire(user_name)
            if (!result.isNullOrEmpty()) {
                matchesModel.postValue(result[0])
                isloading.postValue(false)
            }
        }
    }
}