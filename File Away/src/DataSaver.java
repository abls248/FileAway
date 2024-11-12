import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataSaver {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> records = new ArrayList<>();
        boolean addMore = true;

        while (addMore) {

            String firstName = SafeInput.getNonZeroLenString(scanner, "Enter First Name");
            String lastName = SafeInput.getNonZeroLenString(scanner, "Enter Last Name");
            int id = SafeInput.getRangedInt(scanner, "Enter ID Number (6 digits)", 0, 999999);
            String formattedId = String.format("%06d", id); // Format ID with zero-padding
            String email = SafeInput.getRegExString(scanner, "Enter Email", "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
            int yearOfBirth = SafeInput.getRangedInt(scanner, "Enter Year of Birth", 1900, 2023); // Example range for year

            String record = firstName + ", " + lastName + ", " + formattedId + ", " + email + ", " + yearOfBirth;
            records.add(record);


            addMore = SafeInput.getYNConfirm(scanner, "Do you want to add another record?");
        }

        String fileName = SafeInput.getNonZeroLenString(scanner, "Enter the file name to save (without .csv)") + ".csv";

        try (FileWriter writer = new FileWriter("src/" + fileName)) {
            for (String record : records) {
                writer.write(record + "\n");
            }
            System.out.println("Data successfully saved to " + fileName);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + fileName);
        }

        scanner.close();
    }
}
