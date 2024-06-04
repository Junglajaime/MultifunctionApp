package com.jrb.multifunctionapp
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jrb.multifunctionapp.camera.CameraActivity
import com.jrb.multifunctionapp.musicplayer.MusicPlayerActivity
import com.jrb.multifunctionapp.sensor.SensorActivity
import com.jrb.multifunctionapp.ui.theme.MultifunctionAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MultifunctionAppTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CustomOutlinedButton(
            icon = Icons.Filled.PlayArrow,
            contentDescription = "Music Icon"
        ){context.startActivity(Intent(context, MusicPlayerActivity::class.java))}
        Spacer(modifier = Modifier.height(16.dp))
        CustomOutlinedButton(
            icon = Icons.Filled.AccountCircle,
            contentDescription = "Photo Icon"
        ){context.startActivity(Intent(context, CameraActivity::class.java))}
        Spacer(modifier = Modifier.height(16.dp))
        CustomOutlinedButton(
            painter = painterResource(id = R.drawable.ic_sensor),
            contentDescription = "Star Icon"
        ){context.startActivity((Intent(context, SensorActivity::class.java)))}
    }
}

@Composable
fun CustomOutlinedButton(icon: ImageVector, contentDescription: String, onClick: () -> Unit) {
    OutlinedButton(
        onClick = { onClick() },
        modifier = Modifier.size(60.dp),
        shape = CircleShape,
        border = BorderStroke(1.dp, Color.Gray),
        contentPadding = PaddingValues(0.dp),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = Color.Black.copy(alpha = 0.3f),
            contentColor = Color.White
        )
    ) {
        Icon(
            imageVector = icon,
            contentDescription = contentDescription,
            tint = Color.White
        )
    }
}

@Composable
fun CustomOutlinedButton(painter: Painter, contentDescription: String, onClick: () -> Unit) {
    OutlinedButton(
        onClick = { onClick() },
        modifier = Modifier.size(60.dp),
        shape = CircleShape,
        border = BorderStroke(1.dp, Color.Gray),
        contentPadding = PaddingValues(0.dp),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = Color.Black.copy(alpha = 0.3f),
            contentColor = Color.White
        )
    ) {
        Icon(
            painter = painter,
            contentDescription = contentDescription,
            tint = Color.White
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MultifunctionAppTheme {
        MainScreen()
    }
}