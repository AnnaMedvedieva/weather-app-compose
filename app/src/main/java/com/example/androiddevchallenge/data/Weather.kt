/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.data

import com.example.androiddevchallenge.R

enum class WeatherType {
    CLOUDS, CLOUDS_SUN, CLOUDS_RAIN, CLOUDS_MOON, CLEAR
}

data class Weather(
    val dayOfWeek: String,
    val weatherType: WeatherType,
    val temperatureDay: String,
    val temperatureNight: String,
    val location: String,
    val imageResourse: Int
)

data class WeatherByHour(
    val date: String,
    val hour: String,
    val weatherType: WeatherType,
    val temperatureNow: String,
    val imageResourse: Int,
    val precipitation: String,
    val windSpeed: String,
    val humidity: String
)

val weekForecast = listOf(
    Weather("TUE", WeatherType.CLOUDS, "14°", "4°", "London", R.drawable.ic_clouds),
    Weather("WED", WeatherType.CLOUDS_RAIN, "12°", "5°", "London", R.drawable.ic_rainy),
    Weather("THU", WeatherType.CLOUDS_SUN, "14°", "4°", "London", R.drawable.ic_clouds_sun),
    Weather("FRI", WeatherType.CLOUDS_SUN, "15°", "6°", "London", R.drawable.ic_clouds_sun),
    Weather("SAT", WeatherType.CLOUDS_SUN, "15°", "6°", "London", R.drawable.ic_clouds_sun),
    Weather("SUN", WeatherType.CLOUDS, "16°", "7°", "London", R.drawable.ic_clouds),
    Weather("MON", WeatherType.CLOUDS, "16°", "7°", "London", R.drawable.ic_clouds),
    Weather("TUE", WeatherType.CLOUDS_RAIN, "14°", "6°", "London", R.drawable.ic_rainy),
    Weather("WED", WeatherType.CLOUDS_RAIN, "16°", "8°", "London", R.drawable.ic_rainy),
    Weather("THU", WeatherType.CLOUDS_SUN, "17°", "9°", "London", R.drawable.ic_clouds_sun)
)

val dayForecast = listOf(

    WeatherByHour("22/03", "NOW", WeatherType.CLOUDS_SUN, "12°", R.drawable.ic_clouds_sun, "10%", "6 mph", "15%"),
    WeatherByHour("22/03", "09", WeatherType.CLOUDS, "11°", R.drawable.ic_clouds, "10%", "6 mph", "10%"),
    WeatherByHour("22/03", "10", WeatherType.CLOUDS_SUN, "10°", R.drawable.ic_clouds_sun, "5%", "6 mph", "10%"),
    WeatherByHour("22/03", "11", WeatherType.CLOUDS, "11°", R.drawable.ic_clouds, "10%", "6 mph", "20%"),
    WeatherByHour("22/03", "12", WeatherType.CLOUDS_SUN, "11°", R.drawable.ic_clouds_sun, "10%", "6 mph", "20%"),
    WeatherByHour("22/03", "13", WeatherType.CLOUDS_RAIN, "12°", R.drawable.ic_rainy, "90%", "7 mph", "60%"),
    WeatherByHour("22/03", "14", WeatherType.CLOUDS_RAIN, "13°", R.drawable.ic_rainy, "76%", "6 mph", "62%"),
    WeatherByHour("22/03", "15", WeatherType.CLOUDS_RAIN, "13°", R.drawable.ic_rainy, "60%", "5 mph", "67%"),
    WeatherByHour("22/03", "16", WeatherType.CLOUDS_RAIN, "13°", R.drawable.ic_rainy, "70%", "6 mph", "70%"),
    WeatherByHour("22/03", "17", WeatherType.CLOUDS_RAIN, "13°", R.drawable.ic_rainy, "70%", "6 mph", "72%"),
    WeatherByHour("22/03", "18", WeatherType.CLOUDS_RAIN, "12°", R.drawable.ic_rainy, "60%", "6 mph", "78%"),
    WeatherByHour("22/03", "19", WeatherType.CLOUDS, "10°", R.drawable.ic_clouds, "20%", "7 mph", "23%"),
    WeatherByHour("22/03", "20", WeatherType.CLOUDS, "8°", R.drawable.ic_clouds, "10%", "8 mph", "21%"),
    WeatherByHour("22/03", "21", WeatherType.CLEAR, "7°", R.drawable.ic_moon, "10%", "6 mph", "20%"),
    WeatherByHour("22/03", "22", WeatherType.CLOUDS_MOON, "7°", R.drawable.ic_moon_clouds, "10%", "6 mph", "10%"),
    WeatherByHour("22/03", "23", WeatherType.CLOUDS_MOON, "7°", R.drawable.ic_moon_clouds, "5%", "6 mph", "15%"),
    WeatherByHour("22/03", "00", WeatherType.CLOUDS_MOON, "7°", R.drawable.ic_moon_clouds, "5%", "6 mph", "15%")

)
