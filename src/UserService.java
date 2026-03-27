import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
/**
 * Service class responsible for handling user-related operations
 * such as user registration and input validation.
 * <p>
 * This class manages the interaction with the user through the console,
 * collects user data, validates input, and creates {@link Users} objects
 * depending on the selected role (patient or doctor).
 * </p>
 *
 * @author Martina Molteni
 * @version 1.0
 */
public class UserService {
    /**
     * Registers a new user by collecting input from the console.
     * <p>
     * The method prompts the user to enter personal information such as name,
     * email, password, role, and additional data depending on whether the user
     * is a patient or a doctor. It also validates the role and birth date format.
     * </p>
     *
     * <p>
     * If the role is "doctor", additional professional information is requested
     * such as university, register number, graduation year, and qualification.
     * </p>
     *
     * @param scanner the Scanner object used to read user input from the console
     */

    public static void registerUser(Scanner scanner) {

        System.out.println("\n=== USER REGISTRATION ===");

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        System.out.print("Phone number: ");
        String phone = scanner.nextLine();

        System.out.print("Address: ");
        String address = scanner.nextLine();

        System.out.print("City: ");
        String city = scanner.nextLine();

        System.out.print("Province: ");
        String province = scanner.nextLine();

        String role = "";
        while (true) {
            System.out.print("Role (patient/doctor): ");
            role = scanner.nextLine();

            if (role.equalsIgnoreCase("patient") || role.equalsIgnoreCase("doctor")) {
                break;
            }

            System.out.println("Invalid role, please try again.");
        }


        System.out.print("Tax ID: ");
        String taxID = scanner.nextLine();

        LocalDate birthDate = null;
        while (birthDate == null) {
            System.out.print("Birth Date (dd/MM/yyyy): ");
            String input = scanner.nextLine();
            birthDate = parseBirthDate(input);

            if (birthDate == null) {
                System.out.println("Invalid format. Please try again.");
            }
        }

        Users user;

        if (role.equalsIgnoreCase("doctor")) {

            System.out.print("University: ");
            String university = scanner.nextLine();

            System.out.print("Register number: ");
            String registerNumber = scanner.nextLine();

            System.out.print("Graduation Year: ");
            String graduationYear = scanner.nextLine();

            System.out.print("qualification: ");
            String qualification = scanner.nextLine();

            user = new Users(
                    name, lastName, email, password, phone, address, city, province,
                    role, taxID, university, registerNumber, graduationYear, qualification
            );

        } else {
            user = new Users(
                    name, lastName, email, password, phone, address, city, province,
                    role, taxID
            );
        }

        user.setBirthDate(birthDate);

        // stampa per test
        System.out.println("\nSuccessfully registered user!");
        System.out.println("Nome: " + user.getName());
        System.out.println("Ruolo: " + user.getRole());
        if (user.getRole().equalsIgnoreCase("patient")) {
            System.out.println("Age: " + user.getAge());
        }else if (user.getRole().equalsIgnoreCase("doctor")) {
            System.out.println("Qualification: " + user.getQualification());
        }
    }
    /**
     * Parses a string representing a birth date into a {@link LocalDate}.
     * <p>
     * The expected format is "dd/MM/yyyy". If the input does not match
     * the expected format, the method returns null.
     * </p>
     *
     * @param input the birth date as a string
     * @return the parsed LocalDate if valid, otherwise null
     */
    public static LocalDate parseBirthDate(String input) {
        try {
            return LocalDate.parse(input, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        } catch (Exception e) {
            return null;
        }
    }
}