package com.jrb.multifunctionapp.sensor

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SensorScreen(
    sensorManager: SensorManager,
    proximitySensor: Sensor,
    lightSensor: Sensor,
    accelerometerSensor: Sensor
) {
    var proximity by remember { mutableStateOf(0f) }
    var light by remember { mutableStateOf(0f) }
    var accelerometer by remember { mutableStateOf(floatArrayOf(0f, 0f, 0f)) }

    DisposableEffect(Unit) {
        val sensorListener = object : SensorEventListener {
            override fun onSensorChanged(event: SensorEvent) {
                when (event.sensor.type) {
                    Sensor.TYPE_PROXIMITY -> proximity = event.values[0]
                    Sensor.TYPE_LIGHT -> light = event.values[0]
                    Sensor.TYPE_ACCELEROMETER -> accelerometer = event.values
                }
            }

            override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {}
        }

        sensorManager.registerListener(sensorListener, proximitySensor, SensorManager.SENSOR_DELAY_NORMAL)
        sensorManager.registerListener(sensorListener, lightSensor, SensorManager.SENSOR_DELAY_NORMAL)
        sensorManager.registerListener(sensorListener, accelerometerSensor, SensorManager.SENSOR_DELAY_NORMAL)

        onDispose {
            sensorManager.unregisterListener(sensorListener)
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .padding(40.dp),
            verticalArrangement = Arrangement.spacedBy(40.dp)
        ) {
            Text(text = "Sensor de Proximidad: $proximity cm")
            Text(text = "Sensor de Luz: $light lx")
            Text(
                text = "Sensor de Movimiento: \nX: ${accelerometer[0]} m/s²\nY: ${accelerometer[1]} m/s²\nZ: ${accelerometer[2]} m/s²"
            )
        }
    }
}