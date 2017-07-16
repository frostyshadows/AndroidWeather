package com.example.sherryuan.androidweather

/**
 * API docs: https://openweathermap.org/current
 */

class OpenWeatherResponse(
        val coord: Coord,
        val weather: List<Weather>,
        val main: Main,
        val wind: Wind,
        val clouds: Clouds,
        val dt: Long, // time of calculation
        val sys: System,
        val id: Long, // city ID
        val name: String // city name
)

class Coord(
        val lon: Double,
        val lat: Double
)

class Weather(
        val id: Int,
        val main: String,
        val description: String,
        val icon: String
)

class Main(
        val temp: Double, // default: Kelvin
        val pressure: Int,
        val humidity: Int, // humidity %
        val temp_min: Double,
        val temp_max: Double,
        val sea_level: Int,
        val grnd_level: Int
)

class Wind(
        val speed: Double,
        val deg: Int
)

class Clouds(
        val all: Int // cloudiness, %
)

class System(
        val country: String,
        val sunrise: Long,
        val sunset: Long
)