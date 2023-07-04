package com.example.myappbasquet.di

import android.content.Context
import com.example.myappbasquet.data.local.datastore.DataStoreImpl
import com.example.myappbasquet.data.local.datastore.DataStoreRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun providesDataStore(@ApplicationContext context: Context): DataStoreRepo =
        DataStoreImpl(context)
}