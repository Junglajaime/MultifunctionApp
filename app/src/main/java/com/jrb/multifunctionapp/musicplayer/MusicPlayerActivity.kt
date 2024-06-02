package com.jrb.multifunctionapp.musicplayer


import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import com.jrb.multifunctionapp.ui.theme.MultifunctionAppTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.media3.exoplayer.ExoPlayer
import com.jrb.multifunctionapp.R
import com.jrb.multifunctionapp.model.Music

class MusicPlayerActivity : ComponentActivity() {

    private lateinit var player: ExoPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        player = ExoPlayer.Builder(this).build()
        val playList = getPlayList()

        setContent {

            MultifunctionAppTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    SongScreen(playList, player)
                }

            }
        }
    }


    /***
     * Return a play list of type Music data class
     */
    private fun getPlayList(): List<Music> {
        return listOf(
            Music(
                name = "Master Of Puppets",
                artist = "Metallica",
                cover = R.drawable.master_of_puppets_album_cover,
                music = R.raw.master_of_puppets
            ),
            Music(
                name = "Verano Tercer Movimiento",
                artist = "Vivaldi",
                cover = R.drawable.vivaldi,
                music = R.raw.vivaldi
            ),
            Music(
                name = "Lose Yourself",
                artist = "Eminem",
                cover = R.drawable.lose_yourself_album_cover,
                music = R.raw.lose_yourself
            ),
            Music(
                name = "Crazy",
                artist = "Gnarls Barkley",
                cover = R.drawable.crazy_album_cover,
                music = R.raw.crazy
            ),
            Music(
                name = "Till I Collapse",
                artist = "Eminem",
                cover = R.drawable.till_i_collapse_album_cover,
                music = R.raw.till_i_collapse
            ),
        )
    }




}
