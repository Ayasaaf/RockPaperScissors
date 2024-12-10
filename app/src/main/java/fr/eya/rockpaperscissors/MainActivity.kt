package fr.eya.rockpaperscissors

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.eya.rockpaperscissors.ui.theme.RockPaperScissorsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RockPaperScissorsApp()
        }
    }
}

@Composable
fun RockPaperScissorsApp() {
    var userChoice by remember { mutableStateOf("") }
    var computerChoice by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Rock, Paper, Scissors!", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = {
                userChoice = "Rock"
                playGame("Rock") { computer, gameResult ->
                    computerChoice = computer
                    result = gameResult
                }
            }) {
                Text("Rock")
            }
            Button(onClick = {
                userChoice = "Paper"
                playGame("Paper") { computer, gameResult ->
                    computerChoice = computer
                    result = gameResult
                }
            }) {
                Text("Paper")
            }
            Button(onClick = {
                userChoice = "Scissors"
                playGame("Scissors") { computer, gameResult ->
                    computerChoice = computer
                    result = gameResult
                }
            }) {
                Text("Scissors")
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text("Your Choice: $userChoice")
        Text("Computer's Choice: $computerChoice")
        Text("Result: $result")
    }
}

fun playGame(userChoice: String, onResult: (String, String) -> Unit) {
    val options = listOf("Rock", "Paper", "Scissors")
    val computerChoice = options.random()

    val result = when {
        userChoice == computerChoice -> "It's a tie!"
        userChoice == "Rock" && computerChoice == "Scissors" -> "You win!"
        userChoice == "Paper" && computerChoice == "Rock" -> "You win!"
        userChoice == "Scissors" && computerChoice == "Paper" -> "You win!"
        else -> "You lose!"
    }

    onResult(computerChoice, result)
}