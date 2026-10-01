import java.util.Scanner;
import java.util.concurrent.*;

public class QuizApplication {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] questions = {
            "Which language is used for Android development?",
            "Which keyword is used to create a class in Java?",
            "Which method is the starting point of a Java program?"
        };

        String[][] options = {
            {"1. Java", "2. HTML", "3. SQL", "4. CSS"},
            {"1. define", "2. class", "3. create", "4. object"},
            {"1. start()", "2. run()", "3. main()", "4. begin()"}
        };

        int[] answers = {1, 2, 3};
        int score = 0;

        System.out.println("===== QUIZ APPLICATION =====");
        System.out.println("You have 10 seconds for each question.\n");

        for (int i = 0; i < questions.length; i++) {

            System.out.println("Question " + (i + 1) + ": " + questions[i]);

            for (String option : options[i]) {
                System.out.println(option);
            }

            ExecutorService executor = Executors.newSingleThreadExecutor();

            System.out.print("Enter your answer: ");

            Future<Integer> future = executor.submit(() -> sc.nextInt());

            try {
                int userAnswer = future.get(10, TimeUnit.SECONDS);

                if (userAnswer == answers[i]) {
                    System.out.println("Correct!\n");
                    score++;
                } else {
                    System.out.println("Incorrect!\n");
                }

            } catch (TimeoutException e) {
                System.out.println("\nTime's up!\n");
                future.cancel(true);
            } catch (Exception e) {
                System.out.println("Invalid answer!\n");
                future.cancel(true);
            }

            executor.shutdownNow();
        }

        System.out.println("===== RESULT =====");
        System.out.println("Total Questions: " + questions.length);
        System.out.println("Correct Answers: " + score);
        System.out.println("Wrong Answers: " + (questions.length - score));
        System.out.println("Final Score: " + score + "/" + questions.length);

        sc.close();
    }
}
