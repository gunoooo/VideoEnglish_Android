package kr.hs.dgsw.videoenglish_android.di.module

import dagger.Module
import dagger.Provides
import kr.hs.dgsw.data.repository.*
import kr.hs.dgsw.domain.repository.*
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Singleton
    @Provides
    fun provideSearchRepository(searchRepositoryImpl: SearchRepositoryImpl): SearchRepository = searchRepositoryImpl

    @Singleton
    @Provides
    fun providePlaylistRepository(playlistRepositoryImpl: PlaylistRepositoryImpl): PlaylistRepository = playlistRepositoryImpl

    @Singleton
    @Provides
    fun provideRecordRepository(recordRepositoryImpl: RecordRepositoryImpl): RecordRepository = recordRepositoryImpl

    @Singleton
    @Provides
    fun provideFavoritesRepository(favoritesRepositoryImpl: FavoritesRepositoryImpl): FavoritesRepository = favoritesRepositoryImpl

    @Singleton
    @Provides
    fun provideHidingRepository(hidingRepositoryImpl: HidingRepositoryImpl): HidingRepository = hidingRepositoryImpl

    @Singleton
    @Provides
    fun provideRecentRepository(recentRepositoryImpl: RecentRepositoryImpl): RecentRepository = recentRepositoryImpl

    @Singleton
    @Provides
    fun provideSearchHistoryRepository(searchHistoryRepositoryImpl: SearchHistoryRepositoryImpl): SearchHistoryRepository = searchHistoryRepositoryImpl

    @Singleton
    @Provides
    fun provideSearchSettingRepository(searchSettingRepositoryImpl: SearchSettingRepositoryImpl): SearchSettingRepository = searchSettingRepositoryImpl

    @Singleton
    @Provides
    fun provideWordRepository(wordRepositoryImpl: WordRepositoryImpl): WordRepository = wordRepositoryImpl
}