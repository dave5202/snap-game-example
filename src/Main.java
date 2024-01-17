import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean validResponse = false;

        do {
            System.out.println("Hello! Would you like to play a game of Snap?");
            String userResponse = scanner.nextLine().toLowerCase(); // Convert the input to lowercase for case-insensitivity

            if (userResponse.equals("yes")) {
                System.out.println("Welcome to the game!");
                validResponse = true;
                // Add your game logic here
            } else if (userResponse.equals("no")) {
                System.out.println("Okay, see you soon!");
                validResponse = true;
                // You can close the game or perform any other necessary actions here
            } else {
                System.out.println("Please enter a valid answer of 'yes' or 'no'.");
            }
        } while (!validResponse);

        scanner.close();
    }
}