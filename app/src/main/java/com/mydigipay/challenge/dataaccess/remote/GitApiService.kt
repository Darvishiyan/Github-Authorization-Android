package com.mydigipay.challenge.dataaccess.remote

import com.mydigipay.challenge.dataaccess.model.RequestAccessToken
import com.mydigipay.challenge.dataaccess.model.ResponseAccessToken
import com.mydigipay.challenge.dataaccess.model.ResponseProject
import io.reactivex.Single
import retrofit2.http.*

interface GitApiService {
    @Headers("Accept:application/json")
    @POST("https://github.com/login/oauth/access_token")
    fun getAccessToken(@Body requestAccessToken: RequestAccessToken): Single<ResponseAccessToken>

    @GET("/search/repositories")
    fun getProjects(
        @Query("q") query: String,
        @Query("page") page: Int
    ): Single<ResponseProject>
}