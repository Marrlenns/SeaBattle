import java.util.Arrays;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a, b;
        System.out.print("Please enter the 1st number: ");
        a = scan.nextInt();
        System.out.print("Please enter the 2nd number: ");
        b = scan.nextInt();
        System.out.print("\t1 - Multiplication\n\t2 - Division\n\t3 - Subtraction\n\t4 - Addition\nSelect one of these operations: ");
        int n = scan.nextInt();
        if(n == 1)System.out.printf("%d * %d = %d", a, b, a * b);
        else if(n == 2){
            if(b == 0) System.out.println("Error: Division by ZERO!!!\nTry again.");
            else if(a % b == 0) System.out.printf("%d / %d = %d", a, b, a / b);
            else System.out.printf("%d / %d = %.3f", a, b, (double)a / b);
        } else if(n == 3) System.out.printf("%d - %d = %d", a, b, a - b);
        else if(n == 4) System.out.printf("%d + %d = %d", a, b, a + b);
        else System.out.println("This operation doesn't exist!!!\nTry again.");
//        String s = scan.nextLine();
//        System.out.println(s);
    }
}