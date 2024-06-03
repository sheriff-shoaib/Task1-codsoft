import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int totalScore = 0;
        
        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            boolean GuessedCorrectly = false;
            int maxAttempts = 5;
            
            System.out.println("Welcome to the Guessing Game!");
            System.out.println("I have selected a number between 1 and 100. Try to guess it!");
            System.out.println("You have " + maxAttempts + " attempts.");
            
            while (attempts < maxAttempts && !GuessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;
                
                if (userGuess < numberToGuess) {
                    System.out.println("Too low!");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Congratulations! You've guessed the correct number.");
                    GuessedCorrectly = true;
                }
            }
            
            if (!GuessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The correct number was " + numberToGuess);
            } else {
                totalScore += (maxAttempts - attempts + 1);
            }
            
            System.out.println("Your current score is: " + totalScore);
            System.out.print("Do you want to play again? (yes/no): ");
            String userResponse = scanner.next();
            
            if (userResponse.equalsIgnoreCase("no")) {
                playAgain = false;
            }
        }
        System.out.println("Thank you for playing! Your final score is: " + totalScore);
        scanner.close();
    }
}
