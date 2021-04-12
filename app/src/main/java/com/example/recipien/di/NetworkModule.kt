package com.example.recipien.di

import com.example.recipien.utils.Constances
import com.example.recipien.data.network.RcipeienApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {



    @Singleton
    @Provides
    fun provideOkhttp():OkHttpClient
    {
       return OkHttpClient.Builder().build()
    }

    @Singleton
    @Provides
    fun provideGsonConverter():GsonConverterFactory
    {
        return GsonConverterFactory.create()
    }

    @Singleton
    @Provides
    fun provideRetrofit(client:OkHttpClient,gsonConverter:GsonConverterFactory):Retrofit
    {
        return Retrofit.Builder()
            .baseUrl(Constances.BASE_URL)
            .addConverterFactory(gsonConverter)
            .client(client)
            .build()
    }

    @Singleton
    @Provides
    fun provideRecipeApi(retrofit:Retrofit): RcipeienApi
    {
        return retrofit.create(RcipeienApi::class.java)
    }
}