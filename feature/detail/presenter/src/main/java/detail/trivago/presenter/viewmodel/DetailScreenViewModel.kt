package detail.trivago.presenter.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import detail.trivago.domain.model.Film
import detail.trivago.domain.model.Planet
import detail.trivago.domain.model.Species
import detail.trivago.domain.usecase.FetchFilmUseCase
import detail.trivago.domain.usecase.FetchPlanetUseCase
import detail.trivago.domain.usecase.FetchSpeciesUseCase
import detail.trivago.presenter.contract.CharacterDetailState
import detail.trivago.presenter.model.Character
import detail.trivago.presenter.model.CharacterInfo
import detail.trivago.presenter.model.mapper.toPresenter
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailScreenViewModel
    @Inject
    constructor(
        private val fetchPlanetUseCase: FetchPlanetUseCase,
        private val fetchFilmUseCase: FetchFilmUseCase,
        private val fetchSpeciesUseCase: FetchSpeciesUseCase,
    ) : ViewModel() {
        private val viewModelState = MutableStateFlow(CharacterDetailState())
        val uiState =
            viewModelState.stateIn(
                scope = viewModelScope,
                started = SharingStarted.Eagerly,
                initialValue = viewModelState.value,
            )

        fun getCharacterDetail(character: Character) {
            val coroutineExceptionHandler = CoroutineExceptionHandler { _, _ -> }

            viewModelScope.launch(
                coroutineExceptionHandler,
            ) {
                val planetRequest = async { fetchPlanetUseCase.execute(character.homeWorld) }
                val filmsRequest = async { fetchFilmUseCase.execute(character.films) }
                val speciesRequest = async { fetchSpeciesUseCase.execute(character.species) }

                val (planet, films, species) = awaitAll(planetRequest, filmsRequest, speciesRequest)

                viewModelState.update {
                    it.copy(
                        characterInfo =
                            CharacterInfo(
                                characterName = character.name,
                                birthYear = character.birthYear,
                                height = character.height,
                                species = (species as List<Species>).map { it.toPresenter() },
                                population = (planet as Planet).population,
                                films = (films as List<Film>).map { it.toPresenter() },
                            ),
                    )
                }
            }
        }
    }
