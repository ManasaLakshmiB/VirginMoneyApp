package com.example.virginMoneyapp.di

import com.example.virginMoneyapp.data.remote.ApiCall
import com.example.virginMoneyapp.data.remote.ApiDetail
import com.example.virginMoneyapp.data.repository.Repo
import com.example.virginMoneyapp.data.repository.RepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun provideOkHttInstance(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
    }

    @Provides
    fun provideRetrofitInstance(
        client: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ApiDetail.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    @Provides
    fun provideAPI(
        retrofit: Retrofit
    ): ApiCall {
        return retrofit.create(ApiCall::class.java)
    }

    @Provides
    fun provideRepository(
        apiCall: ApiCall
    ): Repo {
        return RepoImpl(apiCall)
    }
}
