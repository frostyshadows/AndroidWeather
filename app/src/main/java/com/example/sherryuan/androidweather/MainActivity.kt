package com.example.sherryuan.androidweather

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.sherryuan.androidweather.network.OpenWeatherMapApi
import com.example.sherryuan.androidweather.network.format
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), WeatherResponseListener {

    val TEXAS_LAT = 31.9686
    val TEXAS_LONG = -99.9018

    val openWeatherMapApi = OpenWeatherMapApi(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        weather_button.setOnClickListener {
            openWeatherMapApi.fetchWeather(TEXAS_LAT, TEXAS_LONG)
        }
    }

    /**
     * put temperature in the TextView
     */
    override fun onWeatherResponse(openWeatherResponse: OpenWeatherResponse) {
        runOnUiThread {
            weather_text.text = "${(openWeatherResponse.main.temp - 273.15).format(2)} degrees Celcius"
        }
    }
}
