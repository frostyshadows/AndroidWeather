package com.example.sherryuan.androidweather.network

import com.example.sherryuan.androidweather.OpenWeatherResponse
import com.example.sherryuan.androidweather.WeatherResponseListener
import com.google.gson.Gson
import okhttp3.*
import java.io.IOException

/**
 * Documentation: https://openweathermap.org/current
 * We'll use the api.openweathermap.org/data/2.5/weather?lat={lat}&lon={lon} endpoing
 */
class OpenWeatherMapApi(val onWeatherResponseListener: WeatherResponseListener) {
    val BASE_URL = "http://api.openweathermap.org/data/2.5/weather?"
    val API_KEY = "c6ab9931dd703825873a289b36a006fa"

    val client = OkHttpClient()

    /**
     * generates a valid URL for getting the weather from OpenWeatherMap at the specified latlng
     */
    fun generateURL(lat: Double, lon: Double): String =
            "${BASE_URL}lat=$lat&lon=$lon&APPID=$API_KEY"

    /**
     * Fetches weather from OpenWeatherMap, then passesd the response to the listener object
     */
    fun fetchWeather(lat: Double, lon: Double) {
        val request = Request.Builder()
                .url(generateURL(lat, lon))
                .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful)
                    onWeatherResponseListener.onWeatherResponse(Gson().fromJson(response.body()?.string(), OpenWeatherResponse::class.java))
            }
        })
    }
}