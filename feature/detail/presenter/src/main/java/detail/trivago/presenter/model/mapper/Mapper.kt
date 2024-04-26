package detail.trivago.presenter.model.mapper

import detail.trivago.presenter.model.Film
import detail.trivago.presenter.model.Specie
import detail.trivago.domain.model.Film as DomainFilm
import detail.trivago.domain.model.Specie as DomainSpecies

fun DomainSpecies.toPresenter() =
    Specie(
        name = name,
        language = language,
        homeWorld = homeWorld,
    )

fun DomainFilm.toPresenter() =
    Film(
        title = title,
        openingCrawl = openingCrawl,
    )
