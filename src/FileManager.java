import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Utility class responsible for managing file operations related to users.
 * <p>
 * This class handles reading and writing user data to a CSV file.
 * It provides methods to:
 * <ul>
 *     <li>Save a new user to file</li>
 *     <li>Authenticate a user during login</li>
 *     <li>Check if an email is already registered</li>
 * </ul>
 * </p>
 *
 * <p>
 * The user data is stored in a CSV file located at {@code data/users.csv}.
 * Each line represents a user and follows a fixed structure of fields
 * separated by commas.
 * </p>
 *
 * @author Martina Molteni
 * @version 1.0
 */

public class FileManager {

    private static final String FILE_PATH = "data/users.csv";

    /**
     * Saves a user record to the CSV file.
     * <p>
     * The method appends a new line to the file without overwriting existing data.
     * Each user is stored as a comma-separated string representing all user fields.
     * </p>
     *
     * @param line a string representing the user data in CSV format
     */

    public static void saveUser(String line) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(line);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Authenticates a user by checking email and password against stored data.
     * <p>
     * The method reads the CSV file line by line, splits each record,
     * and compares the provided credentials with the stored ones.
     * If a match is found, a {@link Users} object is created and returned.
     * </p>
     *
     * @param email the user's email
     * @param password the user's hashed password
     * @return a {@link Users} object if credentials are valid, otherwise {@code null}
     */

    public static Users login(String email, String password) {

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                String fileEmail = data[2];
                String filePassword = data[3];

                if (fileEmail.equals(email) && filePassword.equals(password)) {

                    return new Users(
                            data[0], data[1], data[2], data[3],
                            data[4], data[5], data[6], data[7],
                            data[8], data[9]
                    );
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Checks whether an email is already registered in the system.
     * <p>
     * The method scans the CSV file and compares the given email with the
     * emails stored in the file (case-insensitive).
     * </p>
     *
     * @param email the email to check
     * @return {@code true} if the email already exists, {@code false} otherwise
     */

    public static boolean emailExists(String email) {

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (data[2].equalsIgnoreCase(email)) {
                    return true;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }
}