package com.marvelapp.data.networking

import com.marvelapp.BuildConfig
import com.marvelapp.domain.GetMD5UseCase
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import java.util.*

class ApiInterceptorMarvel : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val getMD5UseCase = GetMD5UseCase()

        val requestBuilder = chain.request().newBuilder()

        val timestamp = Date().toString()
        val privateKey = BuildConfig.marvel_api_private
        val publicKey = BuildConfig.marvel_api_public

        val hash = runBlocking { getMD5UseCase(timestamp + privateKey + publicKey) }

        requestBuilder.url(
            chain.request().url.newBuilder()
                .addQueryParameter("ts", timestamp)
                .addQueryParameter("apikey", publicKey)
                .addQueryParameter("hash", hash.getOrNull())
                .toString()
        )

        return chain.proceed(requestBuilder.build())
    }
}