package com.example.myappbasquet.data.local.datastore

interface DataStoreRepo {
    suspend fun saveStringValue(key: String, value: String)
    suspend fun getStringValue(key: String): String?
}