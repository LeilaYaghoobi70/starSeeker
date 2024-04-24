package search.trivago.data.mapper

import search.trivago.data.model.CharacterEntity
import search.trivago.domain.model.Character

fun CharacterEntity.mapFromModel(): Character =
    Character(
        name = name,
        birthYear = birthYear,
        height = height,
        films = films,
        homeWorld = homeWorld,
        species = species,
        url = url,
    )
