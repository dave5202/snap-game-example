import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean validResponse = false;

        do {
            System.out.println("Hello! Would you like to watch a game of Snap? Respond with yes or no.");
            String userResponse = scanner.nextLine().toLowerCase();

            if (userResponse.equals("yes")) {
                validResponse = true;
                int rounds = getNumberOfRounds(scanner);
                String snapType = getSnapType(scanner);
                Snap snap = new Snap();
                snap.play(rounds, snapType);
            } else if (userResponse.equals("no")) {
                System.out.println("Okay, see you soon!");
                validResponse = true;
            } else {
                System.out.println("Please enter a valid answer of 'yes' or 'no'.");
            }
        } while (!validResponse);

        scanner.close();
    }

    private static int getNumberOfRounds(Scanner scanner) {
        int numRounds = -1;

        while (numRounds < 1) {
            try {
                System.out.print("Enter the number of rounds you want to watch (a positive integer): ");
                numRounds = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid positive integer.");
                scanner.nextLine(); // Consume the invalid input to avoid an infinite loop
            }
        }

        return numRounds;
    }

    private static String getSnapType(Scanner scanner) {
        boolean validResponse = false;
        String type = "";
        do {
            System.out.println("What type of snap would you like to watch? Say either by 'rank' or by 'suit'");
            String userResponse = scanner.next().toLowerCase();

            if (userResponse.equals("rank")) {
                validResponse = true;
                type = "rank";
            } else if (userResponse.equals("suit")) {
                validResponse = true;
                type = "suit";
            } else {
                System.out.println("Please enter a valid type of 'rank' or 'suit'.");
            }

        } while (!validResponse);

        return type;
    }
}