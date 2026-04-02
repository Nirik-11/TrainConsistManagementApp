import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class TrainConsistManagementApp {

    // Regex patterns
    private static final String TRAIN_ID_PATTERN = "TRN-\\d{4}";
    private static final String CARGO_CODE_PATTERN = "PET-[A-Z]{2}";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for Train ID
        System.out.print("Enter Train ID (Format: TRN-1234): ");
        String trainId = scanner.nextLine();

        // Validate Train ID
        if (validateInput(trainId, TRAIN_ID_PATTERN)) {
            System.out.println("Train ID is valid.");
        } else {
            System.out.println("Invalid Train ID format!");
        }

        // Prompt user for Cargo Code
        System.out.print("Enter Cargo Code (Format: PET-AB): ");
        String cargoCode = scanner.nextLine();

        // Validate Cargo Code
        if (validateInput(cargoCode, CARGO_CODE_PATTERN)) {
            System.out.println("Cargo Code is valid.");
        } else {
            System.out.println("Invalid Cargo Code format!");
        }

        scanner.close();
    }

    // Generic validation method
    private static boolean validateInput(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches(); // ensures exact match
    }
}