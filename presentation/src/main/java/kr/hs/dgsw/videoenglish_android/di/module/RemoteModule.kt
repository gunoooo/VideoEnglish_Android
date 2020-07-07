package kr.hs.dgsw.videoenglish_android.di.module

import dagger.Module
import dagger.Provides
import kr.hs.dgsw.data.network.remote.PlaylistRemote
import kr.hs.dgsw.data.network.remote.SearchRemote
import kr.hs.dgsw.data.network.service.PlaylistService
import kr.hs.dgsw.data.network.service.SearchService
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class RemoteModule {

    @Singleton
    @Provides
    fun provideSearchRemote(retrofit: Retrofit): SearchRemote =
        SearchRemote(retrofit.create(SearchService::class.java))

    @Singleton
    @Provides
    fun providePlaylistRemote(retrofit: Retrofit): PlaylistRemote =
        PlaylistRemote(retrofit.create(PlaylistService::class.java))
}