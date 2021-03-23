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
import com.example.androiddevchallenge.data.Weather

@Composable
fun WeekForecastSection(
    modifier: Modifier = Modifier,
    weekForecastList: List<Weather>
) {
    LazyRow(modifier = modifier) {
        items(weekForecastList) { weatherItem ->
            DailyForecastItem(item = weatherItem)
        }
    }
}

@Composable
fun DailyForecastItem(
    modifier: Modifier = Modifier,
    item: Weather,
) {
    Surface(
        modifier
            .width(64.dp)
            .fillMaxHeight()
            .padding(4.dp),
        color = Color.Transparent

    ) {

        Column(
            verticalArrangement = Arrangement.SpaceEvenly,

        ) {
            Text(
                text = item.dayOfWeek,
                style = MaterialTheme.typography.body1,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Icon(
                painter = painterResource(id = item.imageResourse),
                contentDescription = null,
                Modifier
                    .height(28.dp)
                    .align(Alignment.CenterHorizontally)
            )

            Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                Text(
                    text = item.temperatureDay,
                    style = MaterialTheme.typography.subtitle1,
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = item.temperatureNight,
                    style = MaterialTheme.typography.subtitle1,
                    color = Color.Gray
                )
            }
        }
    }
}
