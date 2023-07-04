package com.example.myappbasquet.data.local.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first
import javax.inject.Inject

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "LOGIN_USER_NAME")

class DataStoreImpl @Inject constructor(private val context: Context) : DataStoreRepo {


    override suspend fun saveStringValue(key: String, value: String) {
        val prefKey = stringPreferencesKey(key)
        context.dataStore.edit {
            it[prefKey] = value
        }
    }

    override suspend fun getStringValue(key: String):String? {
        val prefKey = stringPreferencesKey(key)
        val preferences = context.dataStore.data.first()
        return preferences[prefKey]

    }

}