package app.trivago.data.apiService

import app.trivago.data.model.CharacterRemote
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchApiService {
    @GET(SearchEndPoint.PEOPLE)
    suspend fun fetchCharacterDetail(@Query("search") character: String): CharacterRemote
}
