package app.trivago.starseeker.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import detail.trivago.data.apiService.DetailApiService
import detail.trivago.data.repository.CharacterDetailRepositoryImp
import detail.trivago.domain.repository.CharacterDetailRepository
import retrofit2.Retrofit
import search.trivago.data.apiService.SearchApiService
import search.trivago.data.repository.SearchRepositoryImp
import search.trivago.domain.repository.SearchRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Singleton
    @Provides
    fun provideSearchApiService(retrofit: Retrofit): SearchApiService =
        retrofit.create(
            SearchApiService::class.java,
        )

    @Singleton
    @Provides
    fun provideDetailApiService(retrofit: Retrofit): DetailApiService = retrofit.create(DetailApiService::class.java)

    @Singleton
    @Provides
    fun provideCharacterDetailRepository(detailApiService: DetailApiService): CharacterDetailRepository =
        CharacterDetailRepositoryImp(
            detailApiService = detailApiService,
        )

    @Singleton
    @Provides
    fun provideSearchProcessor(searchApiService: SearchApiService): SearchRepository =
        SearchRepositoryImp(
            searchApiService = searchApiService,
        )
}
