package detail.trivago.presenter.model.mapper

import detail.trivago.presenter.model.Film
import detail.trivago.presenter.model.Species
import detail.trivago.domain.model.Film as DomainFilm
import detail.trivago.domain.model.Species as DomainSpecies

fun DomainSpecies.toPresenter() =
    Species(
        name = name,
        language = language,
        homeWorld = homeWorld,
    )

fun DomainFilm.toPresenter() =
    Film(
        title = title,
        openingCrawl = openingCrawl,
    )
