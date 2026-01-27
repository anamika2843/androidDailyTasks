package com.example.artspaceapp
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}
data class Artwork(
    val imageRes: Int,
    val title: String,
    val artist: String
)
@Composable
fun ArtSpaceApp() {
    val artworks = listOf(
        Artwork(R.drawable.pngtree_hand_drawn, "Design", "abc"),
        Artwork(R.drawable.paintingimages, "Design", "xyz"),
        Artwork(R.drawable.pngtree_painting, "Design", "mno"),
    )
    var currentIndex by remember { mutableStateOf(0) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ArtworkDisplay(artwork = artworks[currentIndex])
        Spacer(modifier = Modifier.height(24.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = {
                currentIndex =
                    if (currentIndex == 0) artworks.size - 1 else currentIndex - 1
            }) {
                Text("Previous")
            }

            Button(onClick = {
                currentIndex =
                    if (currentIndex == artworks.size - 1) 0 else currentIndex + 1
            }) {
                Text("Next")
            }
        }
    }
}
@Composable
fun ArtworkDisplay(artwork: Artwork) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = artwork.imageRes),
            contentDescription = artwork.title,
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = artwork.title,
            fontSize = 24.sp
        )
        Text(
            text = artwork.artist,
            fontSize = 18.sp
        )
    }
}
