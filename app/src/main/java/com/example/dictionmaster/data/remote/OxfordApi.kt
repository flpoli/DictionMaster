package com.example.dictionmaster.data.remote

import com.example.dictionmaster.util.constants.Constants.APP_ID
import com.example.dictionmaster.util.constants.Constants.APP_KEY
import com.example.dictionmaster.data.remote.dto.WordInfoDto
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface OxfordApi {

    @Headers("app_id: $APP_ID", "app_key: $APP_KEY")
    @GET("{lang}/{word}")
      suspend fun getWordInfo(
        @Path("lang") lang: String,
        @Path("word") word: String
    ): WordInfoDto

}

