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

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.WeatherByHour

@Composable
fun DayForecastSection(
    modifier: Modifier = Modifier,
    dayForecastList: List<WeatherByHour>
) {
    LazyRow(modifier = modifier) {
        items(dayForecastList) { weatherItem ->

            WeatherByHourItem(item = weatherItem)
        }
    }
}

@Composable
fun WeatherByHourItem(
    modifier: Modifier = Modifier,
    item: WeatherByHour,
) {
    Surface(
        modifier.width(48.dp)
            .fillMaxHeight()
            .padding(4.dp),
        color = Color.Transparent
    ) {

        Column(
            verticalArrangement = Arrangement.SpaceEvenly,

        ) {
            Text(
                text = item.hour,
                style = MaterialTheme.typography.body2,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Icon(
                painter = painterResource(id = item.imageResourse),
                contentDescription = null,
                Modifier.height(22.dp)
                    .align(Alignment.CenterHorizontally)
            )

            Text(
                text = item.temperatureNow,
                style = MaterialTheme.typography.subtitle2,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}
