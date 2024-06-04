package com.jrb.multifunctionapp.sensor

import android.hardware.Sensor
import android.hardware.SensorManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.jrb.multifunctionapp.ui.theme.MultifunctionAppTheme

class SensorActivity : ComponentActivity() {

    private lateinit var sensorManager: SensorManager
    private lateinit var proximitySensor: Sensor
    private lateinit var lightSensor: Sensor
    private lateinit var accelerometerSensor: Sensor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        proximitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY)!!
        lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)!!
        accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)!!

        enableEdgeToEdge()
        setContent {
            MultifunctionAppTheme {
                SensorScreen(sensorManager,  proximitySensor, lightSensor, accelerometerSensor)
            }
        }
    }
}

