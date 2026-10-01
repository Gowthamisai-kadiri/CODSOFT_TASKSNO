import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {

        Random random = new Random();
        Scanner sc = new Scanner(System.in);

        int number = random.nextInt(100) + 1;
        int guess;
        int attempts = 0;

        System.out.println("===== NUMBER GUESSING GAME =====");
        System.out.println("I have selected a number between 1 and 100.");
        System.out.println("Try to guess it!");

        do {
            System.out.print("Enter your guess: ");
            guess = sc.nextInt();
            attempts++;

            if (guess > number) {
                System.out.println("Too High! Try again.");
            } else if (guess < number) {
                System.out.println("Too Low! Try again.");
            } else {
                System.out.println("Correct! You guessed the number.");
                System.out.println("Number of attempts: " + attempts);
            }

        } while (guess != number);

        sc.close();
    }
}
