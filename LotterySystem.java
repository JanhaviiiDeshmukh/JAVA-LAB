import java.util.Scanner;

public class LotterySystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Generate random 2-digit lottery number (10–99)
        int lottery = (int)(Math.random() * 90) + 10;

        System.out.print("Enter a two digit number: ");
        int user = sc.nextInt();

        System.out.println("Lottery Number: " + lottery);

        // Exact match
        if (user == lottery) {
            System.out.println("Congratulations! You won ₹3000");
        }
        // All digits match (order different)
        else if (checkAllDigits(user, lottery)) {
            System.out.println("Great! All digits match. You won ₹3000");
        }
        // One digit match
        else if (checkOneDigit(user, lottery)) {
            System.out.println("Good! One digit matched. You won ₹1000");
        }
        // No match
        else {
            System.out.println("Sorry! No match.");
        }

        sc.close();
    }

    // Method to check all digits (order ignored)
    static boolean checkAllDigits(int a, int b) {
        int a1 = a / 10;
        int a2 = a % 10;
        int b1 = b / 10;
        int b2 = b % 10;

        return (a1 == b2 && a2 == b1);
    }

    // Method to check one digit match
    static boolean checkOneDigit(int a, int b) {
        int a1 = a / 10;
        int a2 = a % 10;
        int b1 = b / 10;
        int b2 = b % 10;

        return (a1 == b1 || a1 == b2 || a2 == b1 || a2 == b2);
    }
}

