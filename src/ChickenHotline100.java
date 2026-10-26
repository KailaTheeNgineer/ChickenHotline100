import java.util.*;

public class ChickenHotline100 {
    public static void main(String[] args) {

        // Assignment tag
        System.out.println("\n\nDeveloper: Kaila McAlpine | Class: COP-2800/Java Programming | Date: 11/06/2026\n");
        Scanner scanner = new Scanner(System.in);

        // Menu screen and display options
        System.out.print("===========================\n");
        System.out.print("Chicken Hotline 100\n");
        System.out.print("===========================\n");

        // ANSI color codes for error messages
        final String RED = "\u001B[31m";
        final String RESET = "\u001B[0m";

        // Declaring isValid outside the loop so the do-while condition can access it
        boolean isValid;

        // Repeats the program until valid input is entered
        do {

            // Asking user to input a phone number
            System.out.print("Enter a business phone number: \n");

            // Taking user input and making it uppercase
            String phoneNumber = scanner.nextLine().toUpperCase();

            // Resetting validation for every new attempt
            isValid = true;

            // Int variable for valid amount of digits. Resetting the counter for every attempt
            int validDigits = 0;

            // Converting the phoneNumber letters to their corresponding digits
            String convertedNumber = "";

            for (int i = 0; i < phoneNumber.length(); i++) {
                char letter = phoneNumber.charAt(i);

                // Validates that input contains only letters, numbers, or hyphens
                if (!((letter >= 'A' && letter <= 'Z') ||
                    (letter >= '0' && letter <= '9') ||
                    letter == '-')) {

                    isValid = false;
                    break;
                }

                // Counts letters and numbers, excluding hyphens
                if (letter != '-') {
                    validDigits++;
                }

                // Stops processing if more than 11 digits are entered
                if (validDigits > 11) {
                    isValid = false;
                    break;
                }

                // Converts letters into their corresponding numbers
                switch (letter) {
                    case 'A': case 'B': case 'C':
                        convertedNumber += "2";
                        break;
                    case 'D': case 'E': case 'F':
                        convertedNumber += "3";
                        break;
                    case 'G': case 'H': case 'I':
                        convertedNumber += "4";
                        break;
                    case 'J': case 'K': case 'L':
                        convertedNumber += "5";
                        break;
                    case 'M': case 'N': case 'O':
                        convertedNumber += "6";
                        break;
                    case 'P': case 'Q': case 'R': case 'S':
                        convertedNumber += "7";
                        break;
                    case 'T': case 'U': case 'V':
                        convertedNumber += "8";
                        break;
                    case 'W': case 'X': case 'Y': case 'Z':
                        convertedNumber += "9";
                        break;
                    default:
                        convertedNumber += letter;
                }
            }

            // Count all letters and digits in the input
            int totalDigits = 0;

            for (int i = 0; i < phoneNumber.length(); i++) {
                if (phoneNumber.charAt(i) != '-') {
                    totalDigits++;
                }
            }

            // Validates that the phone number contains 10 or 11 digits
            if (totalDigits < 10 || totalDigits > 11) {
            isValid = false;
            System.out.println(RED + "ERROR: Phone number must contain 10 or 11 digits!"+ RESET);

}

            // Only displays results when input is valid
            else if (isValid) {
                System.out.println("----------------------------------");
                System.out.println("  You entered: " + phoneNumber);
                System.out.println("  Converted number: " + convertedNumber);
                System.out.println("----------------------------------");
            }

            // Displays an error when invalid characters are detected
            else {
                System.out.println(RED +
                    "ERROR: Invalid phone number");
                System.out.println(
                    "Please enter only letters, numbers, or hyphens."
                    + RESET);
            }

            // Repeats if isValid is false
        } while (!isValid);

        //Scanner closes only after the loop finishes
        scanner.close();
    }
}