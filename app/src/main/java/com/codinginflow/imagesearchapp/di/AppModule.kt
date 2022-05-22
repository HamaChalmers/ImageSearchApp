package com.codinginflow.imagesearchapp.di

import com.codinginflow.imagesearchapp.api.UnsplashApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Provides //turns into dagger provide methods
    @Singleton //only want one retrofit instance since it takes up unnecessary memory
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(UnsplashApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideUnsplashApi(retrofit: Retrofit): UnsplashApi = //this returns an instance unsplash Api interface
        retrofit.create(UnsplashApi::class.java)

}