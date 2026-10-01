import java.util.*;

public class CourseRegistrationSystem {

    static Scanner sc = new Scanner(System.in);

    static String[] courses = {
        "CS101 - Java Programming",
        "CS102 - Database Management",
        "CS103 - Operating Systems",
        "CS104 - Data Structures"
    };

    static ArrayList<String> registeredCourses = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println("===== STUDENT COURSE REGISTRATION SYSTEM =====");

        while (true) {
            System.out.println("\n1. View Courses");
            System.out.println("2. Register Course");
            System.out.println("3. View Registered Courses");
            System.out.println("4. Drop Course");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    viewCourses();
                    break;

                case 2:
                    registerCourse();
                    break;

                case 3:
                    viewRegisteredCourses();
                    break;

                case 4:
                    dropCourse();
                    break;

                case 5:
                    System.out.println("Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    static void viewCourses() {
        System.out.println("\n===== AVAILABLE COURSES =====");

        for (int i = 0; i < courses.length; i++) {
            System.out.println((i + 1) + ". " + courses[i]);
        }
    }

    static void registerCourse() {
        viewCourses();

        System.out.print("Enter course number to register: ");
        int choice = sc.nextInt();

        if (choice >= 1 && choice <= courses.length) {
            String course = courses[choice - 1];

            if (!registeredCourses.contains(course)) {
                registeredCourses.add(course);
                System.out.println("Course registered successfully.");
            } else {
                System.out.println("You are already registered for this course.");
            }
        } else {
            System.out.println("Invalid course number.");
        }
    }

    static void viewRegisteredCourses() {
        System.out.println("\n===== REGISTERED COURSES =====");

        if (registeredCourses.isEmpty()) {
            System.out.println("No courses registered.");
        } else {
            for (int i = 0; i < registeredCourses.size(); i++) {
                System.out.println((i + 1) + ". " + registeredCourses.get(i));
            }
        }
    }

    static void dropCourse() {
        viewRegisteredCourses();

        if (registeredCourses.isEmpty()) {
            return;
        }

        System.out.print("Enter course number to drop: ");
        int choice = sc.nextInt();

        if (choice >= 1 && choice <= registeredCourses.size()) {
            registeredCourses.remove(choice - 1);
            System.out.println("Course dropped successfully.");
        } else {
            System.out.println("Invalid course number.");
        }
    }
}
