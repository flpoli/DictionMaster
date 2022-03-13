package com.example.dictionmaster.di


import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.dictionmaster.data.local.Converters
import com.example.dictionmaster.data.local.WordInfoDao
import com.example.dictionmaster.data.local.WordInfoDatabase
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
import com.example.dictionmaster.data.repository.WordInfoRepositoryImpl
import com.example.dictionmaster.data.util.GsonParser
import com.example.dictionmaster.domain.repository.WordInfoRepository
import com.example.dictionmaster.util.constants.Constants.BASE_URL
import com.google.gson.Gson
import dagger.Binds
import dagger.hilt.android.qualifiers.ApplicationContext


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
    fun provideWordInfoDataBase(app: Application): WordInfoDatabase {

        return Room.databaseBuilder(
            app,
            WordInfoDatabase::class.java,
            "WordInfoDatabaseDb"
        )
            .addTypeConverter(Converters(GsonParser(Gson())))
            .build()

    }

    @Provides
    @Singleton
    fun provideWordInfoDao(db: WordInfoDatabase): WordInfoDao = db.dao()

    @Provides
    @Singleton
    fun provideWordInfoRepository(api: OxfordApi, dao: WordInfoDao): WordInfoRepository {

        return WordInfoRepositoryImpl(api, dao)
    }

}
