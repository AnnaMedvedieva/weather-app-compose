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
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.WeatherByHour

@Composable
fun WeatherNowSection(
    modifier: Modifier,
    weatherNow: WeatherByHour,
    location: String,
    uvLevel: String
) {

    Column(
        modifier = modifier
    ) {
        Text(
            text = weatherNow.temperatureNow,
            style = MaterialTheme.typography.h1,
        )

        Row(
            Modifier.height(28.dp)
        ) {
            Icon(
                painterResource(id = R.drawable.ic_baseline_location_on_24),
                "Location",
                Modifier
                    .align(Alignment.Bottom)
            )

            Spacer(modifier = Modifier.width(2.dp))

            Text(
                text = location,
                style = MaterialTheme.typography.h2
            )
        }

        Spacer(modifier = Modifier.height(36.dp))

        Row(
            modifier = Modifier
                .padding(
                    horizontal = 4.dp
                )
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Row() {
                Icon(
                    painterResource(id = R.drawable.ic_umbrella),
                    "Precipitation",
                    Modifier.height(12.dp)
                        .align(Alignment.CenterVertically)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = weatherNow.precipitation,
                    style = MaterialTheme.typography.subtitle1,
                )
            }

            Row() {
                Icon(
                    painterResource(id = R.drawable.ic_drop),
                    "Humidity",
                    Modifier
                        .height(12.dp)
                        .align(Alignment.CenterVertically)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = weatherNow.humidity,
                    style = MaterialTheme.typography.subtitle1
                )
            }

            Row() {
                Icon(
                    painterResource(id = R.drawable.ic_wind),
                    "Wind speed",
                    Modifier
                        .height(12.dp)
                        .align(Alignment.CenterVertically)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = weatherNow.windSpeed,
                    style = MaterialTheme.typography.subtitle1
                )
            }

            Row() {
                Icon(
                    painterResource(id = R.drawable.ic_uv),
                    "UV index",
                    Modifier
                        .height(12.dp)
                        .align(Alignment.CenterVertically)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = uvLevel,
                    style = MaterialTheme.typography.subtitle1
                )
            }
        }
    }
}
