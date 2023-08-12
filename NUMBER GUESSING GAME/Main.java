import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        playGame(1, 100, 3); // Limiting to a maximum of 3 games
    }

    public static void playGame(int minRange, int maxRange, int maxGames) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int generatedNumber = random.nextInt(maxRange - minRange + 1) + minRange;
        int attempts = 0;
        int score = 100;
        int totalGames = 0;

        while (totalGames < maxGames) {
            totalGames++;
            System.out.println("Welcome to the number guessing game!");
            System.out.println("Guess the number From " + minRange + " To " + maxRange);

            while (true) {
                System.out.print("Enter your estimate: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == generatedNumber) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    break;
                } else if (userGuess < generatedNumber) {
                    System.out.println("Higher! Try again.");
                } else {
                    System.out.println("Lower! Try again.");
                }

                if (attempts >= 5) {
                    System.out.println("Oops, you have reached the maximum number of attempts!");
                    break;
                }
            }

            score = 100 - (attempts * 5);

            System.out.println("Game over!");
            System.out.println("Your score: " + score);

            if (totalGames < maxGames) {
                System.out.print("Play again? (yes/no): ");
                String playAgain = scanner.next();
                System.out.println();

                if (playAgain.equalsIgnoreCase("yes")) {
                    generatedNumber = random.nextInt(maxRange - minRange + 1) + minRange;
                    attempts = 0;
                    score = 100;
                } else {
                    System.out.println("Thank you for playing.");
                    break;
                }
            } else {
                System.out.println("You have reached the maximum number of games. Thank you for playing.");
            }
        }

        scanner.close();
    }
}
