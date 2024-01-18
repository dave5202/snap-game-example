import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean validResponse = false;

        do {
            System.out.println("Hello! Would you like to watch a game of Snap? Respond with yes or no.");
            // Convert the input to lowercase for case-insensitivity
            String userResponse = scanner.nextLine().toLowerCase();

            if (userResponse.equals("yes")) {
                validResponse = true;
                Snap.play();
            } else if (userResponse.equals("no")) {
                System.out.println("Okay, see you soon!");
                validResponse = true;
            } else {
                System.out.println("Please enter a valid answer of 'yes' or 'no'.");
            }
        } while (!validResponse);

        scanner.close();
    }
}