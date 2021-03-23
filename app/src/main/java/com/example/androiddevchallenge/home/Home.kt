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
package com.example.androiddevchallenge

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.WeatherType
import com.example.androiddevchallenge.home.WeatherViewModel

@ExperimentalAnimationApi
@ExperimentalMaterialApi
@Composable
fun Home(viewModel: WeatherViewModel) {
    Surface(color = MaterialTheme.colors.background) {

        val isDayTime = viewModel.isDayTime
        val todayForecast = viewModel.dayForecast
        val weekForecast = viewModel.weekForecast
        val weatherNow = viewModel.weatherNow
        val typeOfWeather = weatherNow.weatherType
        val location = viewModel.location
        val uvLevel = viewModel.uvLevel

        val scaffoldState = rememberBottomSheetScaffoldState()
        BottomSheetScaffold(
            sheetShape = MaterialTheme.shapes.medium,
            sheetElevation = 0.dp,
            sheetBackgroundColor = MaterialTheme.colors.surface,
            sheetContent = {

                Column(
                    Modifier
                        .fillMaxWidth()
                ) {

                    WeatherNowSection(
                        modifier = Modifier
                            .padding(horizontal = 16.dp),
                        weatherNow,
                        location,
                        uvLevel
                    )

                    Spacer(Modifier.height(24.dp))

                    DayForecastSection(
                        modifier = Modifier
                            .height(92.dp)
                            .padding(horizontal = 12.dp)
                            .fillMaxWidth(),
                        dayForecastList = todayForecast
                    )

                    Spacer(Modifier.height(12.dp))

                    WeekForecastSection(
                        modifier = Modifier
                            .height(112.dp)
                            .padding(horizontal = 12.dp)
                            .fillMaxWidth(),
                        weekForecastList = weekForecast
                    )
                }
            },
            scaffoldState = scaffoldState,
            sheetPeekHeight = 236.dp,

        ) { innerPadding ->
            Column(
                Modifier.fillMaxSize()
            ) {

                AnimatedImage(
                    typeOfWeather = typeOfWeather,
                    isDayTime = isDayTime,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(260.dp)
                )

                Box() {
                    if (typeOfWeather == WeatherType.CLOUDS_RAIN) {
                        RainyBackground()
                    }
                }
            }
        }
    }
}
