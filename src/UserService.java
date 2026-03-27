import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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

        if (FileManager.emailExists(email)) {
            System.out.println("Email already registered!");
            return;
        }

        System.out.print("Password: ");
        String password = hashPassword(scanner.nextLine());

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

        user.setBirthDate(birthDate);

// salva su file
        String line = user.getName() + "," +
                user.getLastName() + "," +
                user.getEmail() + "," +
                user.getPassword() + "," +
                user.getPhoneNumber() + "," +
                user.getAddress() + "," +
                user.getCity() + "," +
                user.getProvince() + "," +
                user.getRole() + "," +
                user.getTaxID();

        FileManager.saveUser(line);

// stampa per test
        System.out.println("\nSuccessfully registered user!");
        System.out.println("Nome: " + user.getName());
        System.out.println("Ruolo: " + user.getRole());

        if (user.getRole().equalsIgnoreCase("patient")) {
            System.out.println("Age: " + user.getAge());
        } else if (user.getRole().equalsIgnoreCase("doctor")) {
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

    /**
     * Handles the user login process by validating email and password.
     * <p>
     * The method prompts the user to enter their email and password,
     * hashes the password using SHA-256, and checks the credentials
     * against the stored data via {@link FileManager#login(String, String)}.
     * </p>
     *
     * <p>
     * If the credentials are valid, the user is logged in and a message is displayed.
     * Depending on the user's role (doctor or patient), the method simulates
     * a redirect to the appropriate dashboard.
     * </p>
     *
     * <p>
     * If the credentials are invalid, an error message is displayed.
     * </p>
     *
     * @param scanner the Scanner object used to read user input from the console
     */

    public static void loginUser(Scanner scanner) {

        System.out.println("\n=== LOGIN ===");

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        // hash della password inserita
        String hashedPassword = hashPassword(password);

        Users user = FileManager.login(email, hashedPassword);

        if (user != null) {
            System.out.println("Login successful!");
            System.out.println("Welcome " + user.getName());

            if (user.getRole().equalsIgnoreCase("doctor")) {
                System.out.println("Redirecting to doctor dashboard...");
            } else {
                System.out.println("Redirecting to patient dashboard...");
            }

        } else {
            System.out.println("Invalid email or password.");
        }
    }

    /**
     * Hashes a plain text password using the SHA-256 algorithm.
     * <p>
     * This method converts the input password into a fixed-length hexadecimal
     * string using a cryptographic hash function. The same input will always
     * produce the same output, but the original password cannot be easily retrieved.
     * </p>
     *
     * @param password the plain text password to hash
     * @return the hashed password as a hexadecimal string
     * @throws RuntimeException if the SHA-256 algorithm is not available
     */

    public static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());

            StringBuilder hexString = new StringBuilder();

            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }


}

