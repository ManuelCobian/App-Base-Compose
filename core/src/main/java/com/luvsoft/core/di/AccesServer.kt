package com.luvsoft.core.di

import android.content.Context
import com.luvsoft.core.domain.Config
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import okio.Buffer
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Singleton
    @Provides
    fun provideOkHttpClient(interceptor: Interceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Config.URL_BASE)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideInterceptor(@ApplicationContext context: Context): Interceptor {
        return object : Interceptor {
            override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
                //val login = AuthResponse.AuthResponse.fromJsonObject()

                val requestBuilder = chain.request().newBuilder()

                    .addHeader("Accept", "application/json")
                    .addHeader("Content-Type", "application/json")

                /*login?.token?.takeIf { it.isNotBlank() }?.let { token ->
                    requestBuilder.addHeader("Authorization", "Bearer $token")
                }*/

                val request = requestBuilder.build()

                println("Sending request ${request.url()}")

                request.body()?.let {
                    val buffer = Buffer()
                    it.writeTo(buffer)
                    println("Request body: ${buffer.readUtf8()}")
                }

                println("Sending request ${request.url()}")

                request.body()?.let {
                    val buffer = Buffer()
                    it.writeTo(buffer)
                    println("Request body: ${buffer.readUtf8()}")
                }

                val response = chain.proceed(request)

                println("Received response for ${response.request().url()}")

                response.body()?.let {
                    val responseBody = it.string()
                    println("Resource body: $responseBody")
                    return response.newBuilder()

                        .body(ResponseBody.create(response.body()!!.contentType(), responseBody))
                        .build()
                }

                return response.newBuilder()
                    .build()
            }
        }
    }
}