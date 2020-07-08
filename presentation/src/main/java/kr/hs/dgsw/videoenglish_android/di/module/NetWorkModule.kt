package kr.hs.dgsw.videoenglish_android.di.module

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import kr.hs.dgsw.data.network.interceptor.ErrorResponseInterceptor
import kr.hs.dgsw.data.util.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.Executors
import javax.inject.Singleton

@Module
class NetWorkModule {
    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val errorResponseInterceptor = ErrorResponseInterceptor()
        val okhttpBuilder = OkHttpClient().newBuilder()
            .addInterceptor(interceptor)
            .addInterceptor(errorResponseInterceptor)
        return okhttpBuilder.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(Constants.TEST_HOST)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .callbackExecutor(Executors.newSingleThreadExecutor())
            .build()
    }
}