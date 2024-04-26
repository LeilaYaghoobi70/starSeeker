package detail.trivago.presenter

import detail.trivago.domain.model.Film
import detail.trivago.domain.model.Planet
import detail.trivago.domain.model.Specie
import detail.trivago.domain.usecase.FetchFilmUseCase
import detail.trivago.domain.usecase.FetchPlanetUseCase
import detail.trivago.domain.usecase.FetchSpeciesUseCase
import detail.trivago.presenter.model.Character
import detail.trivago.presenter.model.CharacterInfo
import detail.trivago.presenter.model.mapper.toPresenter
import detail.trivago.presenter.viewmodel.DetailScreenViewModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class DetailScreenViewModelTest {
    private val fetchPlanetUseCase = mockk<FetchPlanetUseCase>(relaxed = true)
    private val fetchFilmUseCase = mockk<FetchFilmUseCase>(relaxed = true)
    private val fetchSpeciesUseCase = mockk<FetchSpeciesUseCase>(relaxed = true)

    private lateinit var viewModel: DetailScreenViewModel

    @get:Rule
    val mainDispatcherRule = MainCoroutineRule()

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun test() =
        runTest {
            viewModel =
                DetailScreenViewModel(
                    fetchPlanetUseCase = fetchPlanetUseCase,
                    fetchFilmUseCase = fetchFilmUseCase,
                    fetchSpeciesUseCase = fetchSpeciesUseCase,
                ).also {
                    it.uiState.stateIn(CoroutineScope(mainDispatcherRule.testDispatcher))
                }
        }

    @Test
    fun addition_isCorrect() =
        runTest {
            val character =
                Character(
                    name = "Leila",
                    birthYear = "1991",
                    height = "123",
                    films = listOf(""),
                    homeWorld = "",
                    species = listOf(""),
                    url = "",
                )
            val planet = Planet(name = "planet", population = "assume")
            val films =
                listOf(
                    Film(
                        title = "GoodBoy",
                        openingCrawl = "this is fantastic story about good boy who love a bad girl",
                    ),
                )
            val species =
                listOf(
                    Specie(
                        name = "Specie",
                        language = "English",
                        homeWorld = null,
                    ),
                )
            coEvery { fetchPlanetUseCase.execute(character.homeWorld) } returns planet
            coEvery { fetchFilmUseCase.execute(character.films) } returns films
            coEvery { fetchSpeciesUseCase.execute(character.species) } returns species
            val characterInfo =
                CharacterInfo(
                    characterName = character.name,
                    birthYear = character.birthYear,
                    height = character.height,
                    species = species.map { it.toPresenter() },
                    population = planet.population,
                    films = films.map { it.toPresenter() },
                )
            viewModel.getCharacterDetail(character = character)
            Assert.assertEquals(characterInfo, viewModel.uiState.value.characterInfo)
        }
}
