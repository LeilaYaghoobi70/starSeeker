package app.trivago.starseeker.di

import app.trivago.data.apiService.DetailApiService
import app.trivago.data.apiService.SearchApiService
import app.trivago.data.processor.SearchRepositoryImp
import app.trivago.data.repository.CharacterDetailRepositoryImp
import app.trivago.detail.domain.repository.CharacterDetailRepository
import app.trivago.domain.repository.SearchRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideSearchApiService(
        retrofit: Retrofit,
    ): SearchApiService =
        retrofit.create(SearchApiService::class.java)

    @Singleton
    @Provides
    fun provideDetailApiService(
        retrofit: Retrofit,
    ): DetailApiService =
        retrofit.create(DetailApiService::class.java)


    @Singleton
    @Provides
    fun provideCharacterDetailRepository(
        detailApiService: DetailApiService,
    ): CharacterDetailRepository = CharacterDetailRepositoryImp(
        detailApiService = detailApiService
    )

    @Singleton
    @Provides
    fun provideSearchProcessor(
        searchApiService: SearchApiService,
    ): SearchRepository = SearchRepositoryImp(
        searchApiService = searchApiService,
    )

}
