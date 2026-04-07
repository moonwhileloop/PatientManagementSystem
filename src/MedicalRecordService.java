import java.io.*;

public class MedicalRecordService {
    private static final String BASE_PATH = "data/records/";

    public static void readPatientRecord(String taxID) {
        String path = BASE_PATH + taxID + ".txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            System.out.println("\n=== PATIENT RECORD ===");

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("No record found.");
        }
    }

    public static void writePatientRecord(String taxID, String note) {
        String path = BASE_PATH + taxID + ".txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
            writer.write(note);
            writer.newLine();

            System.out.println("Note saved successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
