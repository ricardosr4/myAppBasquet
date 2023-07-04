package com.example.myappbasquet.ui.fragment.login

import androidx.lifecycle.ViewModel
import com.example.myappbasquet.data.local.datastore.DataStoreRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class DataStoreViewModel @Inject constructor(private val dataStoreRepo: DataStoreRepo) :ViewModel() {

    fun storeLoginActive(valueLogin: String)  = runBlocking {
        dataStoreRepo.saveStringValue("LOGIN_ACTIVE", valueLogin)
    }
    fun getLoginActive():String = runBlocking {
        dataStoreRepo.getStringValue("LOGIN_ACTIVE").toString()
    }
    fun storeLoginActiveGoogle(valueLogin: String)  = runBlocking {
        dataStoreRepo.saveStringValue("LOGIN_ACTIVE_GOOGLE", valueLogin)
    }
    fun getLoginActiveGoogle():String = runBlocking {
        dataStoreRepo.getStringValue("LOGIN_ACTIVE_GOOGLE").toString()
    }


}