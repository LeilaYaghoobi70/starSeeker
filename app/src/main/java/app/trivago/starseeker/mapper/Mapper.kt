package app.trivago.starseeker.mapper

import search.trivago.presenter.model.Character
import detail.trivago.presenter.model.Character as DetailCharacter

fun Character.searchToDetail() =
    DetailCharacter(
        name = this.name,
        birthYear = this.birthYear,
        height = this.birthYear,
        films = this.films,
        url = this.url,
        species = this.species,
        homeWorld = this.homeWorld,
    )
