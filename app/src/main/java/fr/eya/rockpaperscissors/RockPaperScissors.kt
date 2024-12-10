package fr.eya.rockpaperscissors

fun main() {
    var playAgain: String

    do {
        var computerChoice = ""
        var userChoice = ""

        println("Rock, Paper or Scissors? Enter your choice:")
        userChoice = readln()

        // Generate computer's choice randomly
        val randomNumber = (1..3).random()
        when (randomNumber) {
            1 -> computerChoice = "Rock"
            2 -> computerChoice = "Paper"
            3 -> computerChoice = "Scissors"
        }

        println("Computer chose: $computerChoice")

        // Check the game outcome
        if (userChoice == computerChoice) {
            println("It's a tie!")
        } else if ((userChoice == "Rock" && computerChoice == "Scissors") ||
            (userChoice == "Paper" && computerChoice == "Rock") ||
            (userChoice == "Scissors" && computerChoice == "Paper")) {
            println("You win!")
        } else {
            println("You lose!")
        }

        // Ask the user if they want to play again
        println("Do you want to play again? (yes/no)")
        playAgain = readln()

    } while (playAgain.equals("yes", ignoreCase = true))

    println("Thanks for playing!")
}