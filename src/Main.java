import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String[] s = scan.nextLine().split(" ");
        for(int i = 0; i < s.length;i ++) System.out.println(s[i]);
    }
}