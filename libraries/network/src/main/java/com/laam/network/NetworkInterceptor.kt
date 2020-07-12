package com.laam.network

import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by luthfiarifin on 7/12/2020.
 */
class NetworkInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val url = request.url()
            .newBuilder()
            .addQueryParameter("api_key", BuildConfig.MOVIE_DB_KEY)
            .addQueryParameter("region", BuildConfig.REGION)
            .build()
        request = request.newBuilder()
            .url(url)
            .build()
        return chain.proceed(request)
    }
}