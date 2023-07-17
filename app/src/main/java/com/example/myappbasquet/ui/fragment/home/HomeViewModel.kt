package com.example.myappbasquet.ui.fragment.home

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myappbasquet.data.remote.model.MatchesEntry
import com.example.myappbasquet.domain.usecase.get.MatchesRemoteUseCase
import com.example.myappbasquet.ui.adapter.MatchesAdapter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getMatchesRemoteUseCase: MatchesRemoteUseCase) :
    ViewModel() {

    var matchesModel = MutableLiveData<List<MatchesEntry>?>()
    val isloading = MutableLiveData<Boolean>()

    fun getMatches(user_name: String) {
        viewModelScope.launch {
            isloading.postValue(true)
            val result = getMatchesRemoteUseCase.getMatchesFire(user_name)
            if (!result.isNullOrEmpty()) {
                matchesModel.postValue(result)
                isloading.postValue(false)
            }
        }
    }
}