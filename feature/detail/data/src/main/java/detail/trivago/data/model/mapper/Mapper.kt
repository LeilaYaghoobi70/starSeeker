package detail.trivago.data.model.mapper

import detail.trivago.data.model.FilmRemote
import detail.trivago.data.model.PlanetRemote
import detail.trivago.data.model.SpecieRemote
import detail.trivago.domain.model.Film
import detail.trivago.domain.model.Planet
import detail.trivago.domain.model.Specie

fun FilmRemote.toDomain() =
    Film(
        title = title,
        openingCrawl = openingCrawl,
    )

fun PlanetRemote.toDomain() =
    Planet(
        name = name,
        population = population,
    )

fun SpecieRemote.toDomain() =
    Specie(
        name = name,
        language = language,
        homeWorld = homeWorld,
    )
