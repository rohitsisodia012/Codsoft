
import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int score = 0;
        boolean playAgain = true;

        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1; // Random number between 1 and 100
            int attemptsLeft = 5;
            boolean guessedCorrectly = false;
            System.out.println("A new round has started! You have 5 attempts to guess the number (between 1 and 100).");

            // Guessing loop
            while (attemptsLeft > 0 && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();

                if (userGuess == numberToGuess) {
                    guessedCorrectly = true;
                    score++;
                    System.out.println("Congratulations! You guessed the number correctly.");
                } else if (userGuess > numberToGuess) {
                    attemptsLeft--;
                    System.out.println("Too high! Attempts left: " + attemptsLeft);
                } else {
                    attemptsLeft--;
                    System.out.println("Too low! Attempts left: " + attemptsLeft);
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry! You've run out of attempts. The correct number was " + numberToGuess);
            }

            // Ask if the player wants to play again
            System.out.print("Would you like to play another round? (yes/no): ");
            String response = scanner.next();
            if (response.equalsIgnoreCase("no")) {
                playAgain = false;
                System.out.println("Thanks for playing! Your final score is: " + score);
            }
        }

        scanner.close();
    }
}
