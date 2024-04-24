package search.trivago.presenter.model

import search.trivago.domain.model.Character as DomainCharacter

fun DomainCharacter.toPresenterCharacter() =
    Character(
        name = name,
        birthYear = birthYear,
        height = height,
        films = films,
        homeWorld = homeWorld,
        species = species,
        url = url,
    )
