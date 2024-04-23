package app.trivago.remote.di

import app.trivago.remote.apiService.StarApiService
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object RemoteModule {

    @Provides
    @Reusable
    fun provideGsonConverterFactory(): Converter.Factory = GsonConverterFactory.create()

    @Provides
    @Singleton
    fun provideOkHttpClient(
        htpLoggingInterceptor: HttpLoggingInterceptor,
    ): OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
       /* if (BuildConfig.DEBUG)
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
*/
        val client = OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .addInterceptor(htpLoggingInterceptor)
            .addNetworkInterceptor(httpLoggingInterceptor)

        return client.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        converterFactory: Converter.Factory,
        client: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://swapi.dev/api/")
            .addConverterFactory(converterFactory)
            .client(client)
            .build()
    }

    @Provides
    private fun makeLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    @Provides
    @Reusable
    fun providePlaceDataService(retrofit: Retrofit): StarApiService =
        retrofit.create(StarApiService::class.java)
}
