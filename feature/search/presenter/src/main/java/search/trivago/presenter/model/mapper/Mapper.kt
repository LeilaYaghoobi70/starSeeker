package search.trivago.presenter.model.mapper

import search.trivago.presenter.model.Character
import search.trivago.domain.model.Character as DomainCharacter

fun DomainCharacter.toPresenter() =
    Character(
        name = name,
        birthYear = birthYear,
        height = height,
        films = films,
        homeWorld = homeWorld,
        species = species,
        url = url,
    )
