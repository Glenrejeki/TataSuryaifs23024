package org.delcom.tatasurya_ifs23024.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import org.delcom.tatasurya_ifs23024.R

data class SpaceData(
    val id: Int,
    @StringRes val nameRes: Int,
    @StringRes val descriptionRes: Int,
    @DrawableRes val imageRes: Int,
    val type: SpaceType,
    val distanceFromSun: String,
    val diameter: String,
    val temperature: String,
    val moons: Int = 0
)

enum class SpaceType {
    PLANET, STAR, GALAXY
}

object SpaceDataSource {
    val spaceItems = listOf(
        SpaceData(
            id = 1,
            nameRes = R.string.mercury_name,
            descriptionRes = R.string.mercury_desc,
            imageRes = R.drawable.ic_mercury, // Ganti dengan ic_ prefix
            type = SpaceType.PLANET,
            distanceFromSun = "57.9 juta km",
            diameter = "4,879 km",
            temperature = "-173°C hingga 427°C",
            moons = 0
        ),
        SpaceData(
            id = 2,
            nameRes = R.string.venus_name,
            descriptionRes = R.string.venus_desc,
            imageRes = R.drawable.ic_venus,
            type = SpaceType.PLANET,
            distanceFromSun = "108.2 juta km",
            diameter = "12,104 km",
            temperature = "462°C",
            moons = 0
        ),
        SpaceData(
            id = 3,
            nameRes = R.string.earth_name,
            descriptionRes = R.string.earth_desc,
            imageRes = R.drawable.ic_earth,
            type = SpaceType.PLANET,
            distanceFromSun = "149.6 juta km",
            diameter = "12,742 km",
            temperature = "-88°C hingga 58°C",
            moons = 1
        ),
        SpaceData(
            id = 4,
            nameRes = R.string.mars_name,
            descriptionRes = R.string.mars_desc,
            imageRes = R.drawable.ic_mars,
            type = SpaceType.PLANET,
            distanceFromSun = "227.9 juta km",
            diameter = "6,779 km",
            temperature = "-87°C hingga -5°C",
            moons = 2
        ),
        SpaceData(
            id = 5,
            nameRes = R.string.jupiter_name,
            descriptionRes = R.string.jupiter_desc,
            imageRes = R.drawable.ic_jupiter,
            type = SpaceType.PLANET,
            distanceFromSun = "778.5 juta km",
            diameter = "139,820 km",
            temperature = "-110°C",
            moons = 79
        ),
        SpaceData(
            id = 6,
            nameRes = R.string.saturn_name,
            descriptionRes = R.string.saturn_desc,
            imageRes = R.drawable.ic_saturn,
            type = SpaceType.PLANET,
            distanceFromSun = "1.4 milyar km",
            diameter = "116,460 km",
            temperature = "-140°C",
            moons = 82
        ),
        SpaceData(
            id = 7,
            nameRes = R.string.uranus_name,
            descriptionRes = R.string.uranus_desc,
            imageRes = R.drawable.ic_uranus,
            type = SpaceType.PLANET,
            distanceFromSun = "2.9 milyar km",
            diameter = "50,724 km",
            temperature = "-195°C",
            moons = 27
        ),
        SpaceData(
            id = 8,
            nameRes = R.string.neptune_name,
            descriptionRes = R.string.neptune_desc,
            imageRes = R.drawable.ic_neptune,
            type = SpaceType.PLANET,
            distanceFromSun = "4.5 milyar km",
            diameter = "49,244 km",
            temperature = "-200°C",
            moons = 14
        ),
        SpaceData(
            id = 9,
            nameRes = R.string.sun_name,
            descriptionRes = R.string.sun_desc,
            imageRes = R.drawable.ic_sun,
            type = SpaceType.STAR,
            distanceFromSun = "0 km",
            diameter = "1.39 juta km",
            temperature = "5,500°C (permukaan)",
            moons = 0
        ),
        SpaceData(
            id = 10,
            nameRes = R.string.milky_way_name,
            descriptionRes = R.string.milky_way_desc,
            imageRes = R.drawable.ic_milky_way,
            type = SpaceType.GALAXY,
            distanceFromSun = "N/A",
            diameter = "100,000 tahun cahaya",
            temperature = "N/A",
            moons = 0
        )
    )

    fun getPlanets() = spaceItems.filter { it.type == SpaceType.PLANET }
    fun getStars() = spaceItems.filter { it.type == SpaceType.STAR }
    fun getGalaxies() = spaceItems.filter { it.type == SpaceType.GALAXY }
    fun getItemById(id: Int) = spaceItems.find { it.id == id }
}