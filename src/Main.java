import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Register");
        System.out.println("2. Login");

        String choice = scanner.nextLine();

        if (choice.equals("1")) {
            UserService.registerUser(scanner);
        } else if (choice.equals("2")) {
            UserService.loginUser(scanner);
        } else {
            System.out.println("Invalid choice");
        }

        scanner.close();
    }
}