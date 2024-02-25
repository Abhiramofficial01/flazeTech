import java.util.*;
import java.util.Scanner;

public class NumberGuessingGame{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1;
        int upperBound = 100;
        int generatedNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;

        int maxAttempts = 5;
        int score = 100; // Starting score

        System.out.println("Welcome to Guess the Number game!");
        System.out.println("Try to guess the number between " + lowerBound + " and " + upperBound);

        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            System.out.print("Attempt " + attempt + " - Enter your guess: ");
            int userGuess = scanner.nextInt();

            if (userGuess == generatedNumber) {
                System.out.println("Congratulations! You guessed the correct number.");
                System.out.println("Your score: " + score);
                break;
            } else {
                System.out.println("Wrong guess!");

                if (userGuess < generatedNumber) {
                    System.out.println("The number is higher.");
                } else {
                    System.out.println("The number is lower.");
                }

                // Deduct points for each incorrect attempt
                score -= 20;
            }
        }

        System.out.println("The correct number was: " + generatedNumber);
        scanner.close();
    }
}
