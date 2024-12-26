import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame{
    private static final int MAX_ATTEMPTS = 10;
    private static final int MAX_NUMBER = 100;
    private static final int MIN_NUMBER = 1;

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            Random rm = new Random();
            int score = 0;
            
            System.out.println("Welcome to the Number Guessing Game!");
            
            while (true) {
                int targetNumber = rm.nextInt(MAX_NUMBER - MIN_NUMBER +1) +MIN_NUMBER;
                int roundScore = playRound(sc,targetNumber);
                score += roundScore;
                System.out.println("Your current score is: " + score);
                System.out.println("Play again? (yes/no)");
                String response = sc.next().toLowerCase();
                if (!response.equals("yes")) {
                    break;
                }
            }
            System.out.println("Thank you for playing! Your final score is: " + score);
        }
}
public static int playRound(Scanner sc, int targetNumber) {
    System.out.println("\nNew Round!");
    System.out.println("I have selected a number between " + MIN_NUMBER + " and " + MAX_NUMBER + ".");
    System.out.println("You have " + MAX_ATTEMPTS + " attempts.");

    for (int attempt = 1; attempt <= MAX_ATTEMPTS; attempt++) {
        System.out.print("Attempt " + attempt + ": Enter your guess: ");
        int guess = getUserInput(sc);

        if (guess < targetNumber) {
            System.out.println("Too low! Try again.");
        } else if (guess > targetNumber) {
            System.out.println("Too high! Try again.");
        } else {
            System.out.println("Congratulations! You guessed the correct number " + targetNumber + " in " + attempt + " attempts.");
            return MAX_ATTEMPTS - attempt + 1;
        }
    }
    System.out.println("Sorry! You've used all " + MAX_ATTEMPTS + " attempts. The correct number was " + targetNumber + ".");
        return 0;
    }

    private static int getUserInput(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid number: ");
            }
        }
    }

    private static boolean askToPlay(Scanner scanner) {
        System.out.print("Do you want to play another round? (yes/no): ");
        String response = scanner.nextLine().trim().toLowerCase();
        return response.equals("yes");
    }
}

    