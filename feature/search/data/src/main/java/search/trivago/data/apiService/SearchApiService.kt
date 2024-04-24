package search.trivago.data.apiService

import retrofit2.http.GET
import retrofit2.http.Query
import search.trivago.data.model.SearchEntity

interface SearchApiService {
    @GET(SearchEndPoint.PEOPLE)
    suspend fun fetchCharacter(
        @Query("search") query: String,
    ): SearchEntity?
}
