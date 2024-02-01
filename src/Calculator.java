import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        do {
            double num1 = getNumber("Enter first number: ");
            double num2 = getNumber("Enter second number: ");
            char operation = getOperation("Enter operation (+-*/): ");

            double res = switch (operation) {
                case '+' -> num1 + num2;
                case '-' -> num1 - num2;
                case '*' -> num1 * num2;
                case '/' -> num1 / num2;
                default -> throw new IllegalStateException("Unexpected value: " + operation);
            };

            System.out.println("Result: " + res);
        } while (isContinue());
    }

    public static double getNumber(String message) {
        Scanner scanner = new Scanner(System.in);

        double num;
        while (true) {
            System.out.print(message);
            try {
                num = Double.parseDouble(scanner.nextLine());
            }
            catch (NumberFormatException ex) {
                System.out.println("Invalid input. Try again...");
                continue;
            }
            break;
        }

        return num;
    }

    public static char getOperation(String message) {
        Scanner scanner = new Scanner(System.in);

        String operation;
        while (true) {
            System.out.print(message);
            operation = scanner.nextLine();
            if (operation.length() > 1 || !"+-*/".contains(operation)) {
                System.out.println("Invalid input. Try again...");
                continue;
            }
            break;
        }

        return operation.charAt(0);
    }

    public static boolean isContinue() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Do you want to continue? (y/n): ");
            String input = scanner.nextLine();
            switch (input) {
                case "y":
                    return true;
                case "n":
                    return false;
                default:
                    System.out.println("Invalid input. Try again...");
            }
        }
    }
}
