package com.example.dictionmaster.di


import android.app.Application
import com.example.dictionmaster.data.local.WordDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import javax.inject.Singleton
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.dictionmaster.data.remote.OxfordApi
import com.example.dictionmaster.repository.SearchRepository
import com.example.dictionmaster.util.constants.Constants.BASE_URL


@Module
@InstallIn(SingletonComponent::class)
class AppModule {


    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {

        return OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            )
            .build()
    }

    @Provides
    @Singleton
    fun provideOxfordApi(client: OkHttpClient): OxfordApi {

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(client)
            .build()
            .create(OxfordApi::class.java)
    }

    @Provides
    @Singleton
    fun provideSearchRepository(api: OxfordApi) = SearchRepository(api)

}

//    @Provides
//    @Singleton
//    fun provideDataBase(app: Application): WordDb {
//
//        return
//
//    }