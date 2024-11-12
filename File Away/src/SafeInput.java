import java.util.Scanner;

public class SafeInput {
    public SafeInput() {
    }

    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = "";

        do {
            System.out.print("\n" + prompt + ": ");
            retString = pipe.nextLine();
        } while(retString.length() == 0);

        return retString;
    }

    public static int getInt(Scanner pipe, String prompt) {
        int retValue = 0;
        boolean validInput = false;

        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextInt()) {
                retValue = pipe.nextInt();
                validInput = true;
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                pipe.next();
            }

            pipe.nextLine();
        } while(!validInput);

        return retValue;
    }

    public static double getDouble(Scanner pipe, String prompt) {
        double retValue = 0.0;
        boolean validInput = false;

        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextDouble()) {
                retValue = pipe.nextDouble();
                validInput = true;
            } else {
                System.out.println("Invalid input. Please enter a valid double.");
                pipe.next();
            }

            pipe.nextLine();
        } while(!validInput);

        return retValue;
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int retValue = 0;
        boolean validInput = false;

        do {
            System.out.print("\n" + prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextInt()) {
                retValue = pipe.nextInt();
                if (retValue >= low && retValue <= high) {
                    validInput = true;
                } else {
                    System.out.println("Input out of range. Please enter a number between " + low + " and " + high + ".");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                pipe.next();
            }

            pipe.nextLine();
        } while(!validInput);

        return retValue;
    }

    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        double retValue = 0.0;
        boolean validInput = false;

        do {
            System.out.print("\n" + prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextDouble()) {
                retValue = pipe.nextDouble();
                if (retValue >= low && retValue <= high) {
                    validInput = true;
                } else {
                    System.out.println("Input out of range. Please enter a number between " + low + " and " + high + ".");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid double.");
                pipe.next();
            }

            pipe.nextLine();
        } while(!validInput);

        return retValue;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        boolean validInput = false;
        boolean result = false;

        do {
            System.out.print("\n" + prompt + " [Y/N]: ");
            String response = pipe.nextLine().trim();
            if (response.equalsIgnoreCase("Y")) {
                result = true;
                validInput = true;
            } else if (response.equalsIgnoreCase("N")) {
                result = false;
                validInput = true;
            } else {
                System.out.println("Invalid input. Please enter Y or N.");
            }
        } while(!validInput);

        return result;
    }

    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        boolean validInput = false;

        String input;
        do {
            System.out.print("\n" + prompt + ": ");
            input = pipe.nextLine();
            if (input.matches(regEx)) {
                validInput = true;
            } else {
                System.out.println("Invalid input. Please ensure the input matches the required format.");
            }
        } while(!validInput);

        return input;
    }

    public static void prettyHeader(String msg) {
        int totalWidth = 60;
        int msgLength = msg.length();
        int padding = (totalWidth - msgLength - 6) / 2;

        int i;
        for(i = 0; i < totalWidth; ++i) {
            System.out.print("*");
        }

        System.out.println();
        System.out.print("***");

        for(i = 0; i < padding; ++i) {
            System.out.print(" ");
        }

        System.out.print(msg);

        for(i = 0; i < padding; ++i) {
            System.out.print(" ");
        }

        System.out.println("***");

        for(i = 0; i < totalWidth; ++i) {
            System.out.print("*");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput = getNonZeroLenString(scanner, "Enter your name");
        System.out.println("You entered: " + userInput);
        int userInt = getInt(scanner, "Enter an integer");
        System.out.println("You entered the integer: " + userInt);
        double userDouble = getDouble(scanner, "Enter a double");
        System.out.println("You entered the double: " + userDouble);
        int rangedInt = getRangedInt(scanner, "Enter a number", 10, 20);
        System.out.println("You entered the number: " + rangedInt);
        double rangedDouble = getRangedDouble(scanner, "Enter a number", 5.5, 10.5);
        System.out.println("You entered the number: " + rangedDouble);
        boolean confirm = getYNConfirm(scanner, "Do you want to continue?");
        System.out.println("You selected: " + (confirm ? "Yes" : "No"));
        String regExInput = getRegExString(scanner, "Enter a valid email", "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
        System.out.println("You entered a valid email: " + regExInput);
        scanner.close();
    }
}

