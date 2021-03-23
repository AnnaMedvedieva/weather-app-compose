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
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.WeatherType

@ExperimentalAnimationApi
@Composable
fun AnimatedImage(
    typeOfWeather: WeatherType,
    isDayTime: Boolean,
    modifier: Modifier
) {

    val infiniteTransition = rememberInfiniteTransition()

    val imageResource =
        if (isDayTime) painterResource(id = R.drawable.sun)
        else painterResource(id = R.drawable.moon)
    val weather = typeOfWeather

    val positionStateOne = infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 3300,
                easing = LinearEasing
            ),
            repeatMode = RepeatMode.Reverse
        )
    )

    val positionStateTwo = infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                delayMillis = 50,
                durationMillis = 3000,
                easing = LinearEasing
            ),
            repeatMode = RepeatMode.Reverse
        )
    )

    val positionStateThree = infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                delayMillis = 150,
                durationMillis = 3000,
                easing = LinearEasing
            ),
            repeatMode = RepeatMode.Reverse
        )
    )

    Box(
        modifier = modifier
    ) {

        if (weather == WeatherType.CLOUDS_SUN ||
            weather == WeatherType.CLOUDS_MOON ||
            weather == WeatherType.CLEAR
        ) {
            Image(
                painter = imageResource, contentDescription = "The sun or the moon",
                alpha = 0.7F,
                modifier = Modifier
                    .padding(end = 28.dp, bottom = 12.dp)
                    .align(Alignment.BottomEnd)
            )
        }

        if (weather == WeatherType.CLOUDS_SUN ||
            weather == WeatherType.CLOUDS_MOON ||
            weather == WeatherType.CLOUDS ||
            weather == WeatherType.CLOUDS_RAIN

        ) {

            Image(
                painter = painterResource(id = R.drawable.clouds_small), contentDescription = null,
                alpha = 0.6F,
                modifier = Modifier
                    .offset(
                        x = -(30).dp * positionStateOne.value,
                        y = -(30).dp * positionStateOne.value
                    )
                    .align(Alignment.TopStart)
            )

            Image(
                painter = painterResource(id = R.drawable.clouds_large_white), contentDescription = null,
                alpha = 0.4F,
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .offset(
                        x = -(10).dp,
                        y = -(10).dp
                    )
                    .fillMaxWidth()
            )

            Image(
                painter = painterResource(id = R.drawable.clouds_large),
                contentDescription = null,
                alpha = 0.6F,
                modifier = Modifier
                    .offset(
                        x = 20.dp * positionStateTwo.value,
                        y = -(20).dp * positionStateTwo.value
                    )
                    .align(Alignment.TopEnd)
                    .height(220.dp)

            )

            Image(
                painter = painterResource(id = R.drawable.clouds_large),
                contentDescription = null,
                alpha = 0.4F,
                modifier = Modifier
                    .offset(
                        x = -(15).dp * positionStateThree.value,
                        y = 5.dp * positionStateThree.value
                    )
                    .align(Alignment.TopStart)
            )
        }

        IconButton(
            onClick = {},
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(2.dp)
        ) {
            Icon(painter = painterResource(id = R.drawable.ic_baseline_settings_24), contentDescription = null)
        }
    }
}
@Composable
fun RainyBackground() {

    val infiniteTransition = rememberInfiniteTransition()

    val positionState = infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1500,
                easing = LinearEasing
            ),
        )
    )

    val imageResource = if (positionState.value <= 0.5f) painterResource(id = R.drawable.raindrops_one) else painterResource(id = R.drawable.raindrops_two)

    Image(
        painter = imageResource,
        contentDescription = null,
        modifier = Modifier
            .fillMaxSize(),
        contentScale = ContentScale.Crop
    )
}
