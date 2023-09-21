import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
 // █░❌


public class Master {

    public static char[][] SeaBattle(){
        char[][] ar = new char[8][8];
        for(int i = 0; i < 8; i++)for(int j = 0; j < 8; j++)ar[i][j] = '•';
        int a1 = 1, a2 = 2, a4 = 4;
        Random rand = new Random();
        while(a1 > 0 || a2 > 0 || a4 > 0){
            if(a1 > 0){
                boolean flag = true;
                while(flag){
                    int i = rand.nextInt(1, 8);
                    int j = rand.nextInt(1, 8);
                    int r = rand.nextInt(1, 3);
                    if(r == 1){
                        if (j > 1 && j < 7){
                            ar[i][j] = '3';
                            ar[i][j - 1] = '3';
                            ar[i][j + 1] = '3';
                            flag = false;
                        }
                    } else{
                        if(i > 1 && i < 7){
                            ar[i][j] = '3';
                            ar[i - 1][j] = '3';
                            ar[i + 1][j] = '3';
                            flag = false;
                        }
                    }
                }
                a1 --;
            } else if(a2 > 0){
                boolean flag = true;
                while(flag){
                    int i = rand.nextInt(1, 8);
                    int j = rand.nextInt(1, 8);
                    int r = rand.nextInt(1, 3);
                    if(r == 1){
                        if(j > 1 && ar[i][j] == '•' && ar[i][j - 1] == '•'){
                            boolean buffer = true;
                            if(j > 2 && ar[i][j - 2] != '•')buffer = false;
                            else if(j < 7 && ar[i][j + 1] != '•')buffer = false;
                            else if((i > 1 && ar[i - 1][j] != '•') || (i > 1 && ar[i - 1][j - 1] != '•'))buffer = false;
                            else if(i > 1 && j > 2 && ar[i - 1][j - 2] != '•')buffer = false;
                            else if(j < 7 && i > 1 && ar[i - 1][j + 1] != '•')buffer = false;
                            else if(j < 7 && i < 7 && ar[i + 1][j + 1] != '•')buffer = false;
                            else if((i < 7 && ar[i + 1][j] != '•') || (i < 7 && ar[i + 1][j - 1] != '•'))buffer = false;
                            else if(j > 2 && i < 7 && ar[i + 1][j - 2] != '•')buffer = false;
                            if(buffer){
                                ar[i][j] = '2';
                                ar[i][j - 1] = '2';
                                flag = false;
                            }
                        } else if(j < 7 && ar[i][j] == '•' && ar[i][j + 1] == '•'){
                            boolean buffer = true;
                            if(j > 1 && ar[i][j - 1] != '•')buffer = false;
                            else if(j > 1 && i > 1 && ar[i - 1][j - 1] != '•')buffer = false;
                            else if((i > 1 && ar[i - 1][j] != '•') || (i > 1 && ar[i - 1][j + 1] != '•'))buffer = false;
                            else if(j < 6 && i > 1 && ar[i - 1][j + 2] != '•')buffer = false;
                            else if(j < 6 && ar[i][j + 2] != '•')buffer = false;
                            else if(j < 6 && i < 7 && ar[i + 1][j + 2] != '•')buffer = false;
                            else if((i < 7 && ar[i + 1][j] != '•') || (i < 7 && ar[i + 1][j + 1] != '•'))buffer = false;
                            else if(j > 1 && i < 7 && ar[i + 1][j - 1] != '•')buffer = false;
                            if(buffer){
                                ar[i][j] = '2';
                                ar[i][j + 1] = '2';
                                flag = false;
                            }
                        }
                    } else{
                        if(i > 1 && ar[i][j] == '•' && ar[i - 1][j] == '•'){
                            boolean buffer = true;
                            if(i > 2 && j > 1 && ar[i - 2][j - 1] != '•')buffer = false;
                            else if(i > 2 && ar[i - 2][j] != '•')buffer = false;
                            else if(i > 2 && j < 7 && ar[i - 2][j + 1] != '•')buffer = false;
                            else if((j < 7 && ar[i - 1][j + 1] != '•') || (j < 7 && ar[i][j + 1] != '•'))buffer = false;
                            else if(i < 7 && j < 7 && ar[i + 1][j + 1] != '•')buffer = false;
                            else if(i < 7 && ar[i + 1][j] != '•')buffer = false;
                            else if(i < 7 && j > 1 && ar[i + 1][j - 1] != '•')buffer = false;
                            else if((j > 1 && ar[i - 1][j - 1] != '•') || (j > 1 && ar[i][j - 1] != '•'))buffer = false;
                            if(buffer){
                                ar[i][j] = '2';
                                ar[i - 1][j] = '2';
                                flag = false;
                            }
                        } else if(i < 7 && ar[i][j] == '•' && ar[i + 1][j] == '•'){
                            boolean buffer = true;
                            if(i > 1 && j > 1 && ar[i - 1][j - 1] != '•')buffer = false;
                            else if(i > 1 && ar[i - 1][j] != '•')buffer = false;
                            else if(i > 1 && j < 7 && ar[i - 1][j + 1] != '•')buffer = false;
                            else if((j < 7 && ar[i + 1][j + 1] != '•') || (j < 7 && ar[i][j + 1] != '•'))buffer = false;
                            else if(i < 6 && j < 7 && ar[i + 2][j + 1] != '•')buffer = false;
                            else if(i < 6 && ar[i + 2][j] != '•')buffer = false;
                            else if(i < 6 && j > 1 && ar[i + 2][j - 1] != '•')buffer = false;
                            else if((j > 1 && ar[i + 1][j - 1] == '*') || (j > 1 && ar[i][j - 1] != '•'))buffer = false;
                            if(buffer){
                                ar[i][j] = '2';
                                ar[i + 1][j] = '2';
                                flag = false;
                            }
                        }
                    }
                }
                a2 --;
            } else{
                int i = rand.nextInt(1, 8);
                int j = rand.nextInt(1, 8);
                if(ar[i][j] == '•'){
                    boolean buffer = true;
                    if(i > 1 && j > 1 && ar[i - 1][j - 1] != '•')buffer = false;
                    else if(i > 1 && ar[i - 1][j] != '•')buffer = false;
                    else if(i > 1 && j < 7 && ar[i - 1][j + 1] != '•')buffer = false;
                    else if(j < 7 && ar[i][j + 1] != '•')buffer = false;
                    else if(i < 7 && j < 7 && ar[i + 1][j + 1] != '•')buffer = false;
                    else if(i < 7 && ar[i + 1][j] != '•')buffer = false;
                    else if(i < 7 && j > 1 && ar[i + 1][j - 1] != '•')buffer = false;
                    else if(j > 1 && ar[i][j - 1] != '•')buffer = false;
                    if(buffer){
                        ar[i][j] = '1';
                        a4 --;
                    }
                }
            }
        }
        return ar;
    }

    public static boolean Search(char[][] ar){
        int sum = 0;
        for(int i = 1; i < 8; i++){
            for(int j = 1; j < 8; j++){
                if(ar[i][j] == '+')sum ++;
            }
        }
        return sum != 11;
    }

    public static int[] Enter(boolean used){
        Scanner scanner = new Scanner(System.in);
        boolean ent = true;
        int a = 0, b = 0;
        if(used) System.out.print("You already attacked these coordinates\nEnter other coordinates: ");
        else System.out.print("Enter the coordinates: ");
        while(ent){
            boolean buffer = true;
            String[] s = scanner.nextLine().split(" ");
            if(s.length == 2){
                if(s[0].length() > 1 || s[1].length() > 1){
                    System.out.print("You must enter only two coordinates in this format:\n\t1) \"2 5\"\n\t2) \"B 5\"\n\t3) \"b 5\"\nRange: 1-7, A-G, a-g\nRe-enter the coordinates: ");
                    buffer = false;
                }
                else{
                    if(s[1].matches("[a-zA-Z]+")){
                        buffer = false;
                        System.out.print("You must enter only two coordinates in this format:\n\t1) \"2 5\"\n\t2) \"B 5\"\n\t3) \"b 5\"\nRange: 1-7, A-G, a-g\nRe-enter the coordinates: ");
                    }
                    else b = Integer.parseInt(s[1]);
                    if(s[0].matches("[a-zA-Z0-9]*")){
                        if(s[0].matches("[a-zA-Z]+")){
                            char k = s[0].toUpperCase().charAt(0);
                            a = k - 64;
                        } else a = s[0].charAt(0) - 48;
                    } else{
                        buffer = false;
                        System.out.print("You must enter only two coordinates in this format:\n\t1) \"2 5\"\n\t2) \"B 5\"\n\t3) \"b 5\"\nRange: 1-7, A-G, a-g\nRe-enter the coordinates: ");
                    }
                }
            }else{
                System.out.print("You must enter only two coordinates in this format:\n\t1) \"2 5\"\n\t2) \"B 5\"\n\t3) \"b 5\"\nRange: 1-7, A-G, a-g\nRe-enter the coordinates: ");
                buffer = false;
            }

            if(buffer){
                if(a < 1 || a > 7 || b < 1 || b > 7) System.out.print("You must enter only two coordinates in this format:\n\t1) \"2 5\"\n\t2) \"B 5\"\n\t3) \"b 5\"\nRange: 1-7, A-G, a-g\nRe-enter the coordinates: ");
                else ent = false;
            }
        }
        int[] ar = new int[2];
        ar[0] = a;
        ar[1] = b;
        return ar;
    }

    public static void FieldOutput(char[][] ar){
        System.out.println("  1 2 3 4 5 6 7");
        for(int i = 1; i < 8; i++){
            System.out.print((char)(i + 64) + " ");
            for(int j = 1; j < 8; j++) System.out.print(ar[i][j] + " ");
            System.out.println();
        }
    }

    public static char[][] ShipSunk2(char[][] ans, int a, int b, int c, int d){
        int i = a, j = b;
        if(i > 1 && ans[i - 1][j] != '⬛' && ans[i - 1][j] != '+')ans[i - 1][j] = '⚪';
        if(i < 7 && ans[i + 1][j] != '⬛' && ans[i + 1][j] != '+')ans[i + 1][j] = '⚪';
        if(j > 1 && ans[i][j - 1] != '⬛' && ans[i][j - 1] != '+')ans[i][j - 1] = '⚪';
        if(j < 7 && ans[i][j + 1] != '⬛' && ans[i][j + 1] != '+')ans[i][j + 1] = '⚪';
        if(i > 1 && j > 1 && ans[i - 1][j - 1] != '⬛' && ans[i - 1][j - 1] != '+')ans[i - 1][j - 1] = '⚪';
        if(i > 1 && j < 7 && ans[i - 1][j + 1] != '⬛' && ans[i - 1][j + 1] != '+')ans[i - 1][j + 1] = '⚪';
        if(i < 7 && j > 1 && ans[i + 1][j - 1] != '⬛' && ans[i + 1][j - 1] != '+')ans[i + 1][j - 1] = '⚪';
        if(i < 7 && j < 7 && ans[i + 1][j + 1] != '⬛' && ans[i + 1][j + 1] != '+')ans[i + 1][j + 1] = '⚪';
        i = c;
        j = d;
        if(i > 1 && ans[i - 1][j] != '⬛' && ans[i - 1][j] != '+')ans[i - 1][j] = '⚪';
        if(i < 7 && ans[i + 1][j] != '⬛' && ans[i + 1][j] != '+')ans[i + 1][j] = '⚪';
        if(j > 1 && ans[i][j - 1] != '⬛' && ans[i][j - 1] != '+')ans[i][j - 1] = '⚪';
        if(j < 7 && ans[i][j + 1] != '⬛' && ans[i][j + 1] != '+')ans[i][j + 1] = '⚪';
        if(i > 1 && j > 1 && ans[i - 1][j - 1] != '⬛' && ans[i - 1][j - 1] != '+')ans[i - 1][j - 1] = '⚪';
        if(i > 1 && j < 7 && ans[i - 1][j + 1] != '⬛' && ans[i - 1][j + 1] != '+')ans[i - 1][j + 1] = '⚪';
        if(i < 7 && j > 1 && ans[i + 1][j - 1] != '⬛' && ans[i + 1][j - 1] != '+')ans[i + 1][j - 1] = '⚪';
        if(i < 7 && j < 7 && ans[i + 1][j + 1] != '⬛' && ans[i + 1][j + 1] != '+')ans[i + 1][j + 1] = '⚪';
        System.out.println("------SUNK------");
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter your name: ");
//        String s = scanner.nextLine();
        char[][] ar = SeaBattle(), ans = new char[8][8];
        for(int i = 0; i < 8; i++)for(int j = 0; j < 8; j++)ans[i][j] = '•';
        boolean flag = true, used = false;
        int count = 0;
        while(flag){
            if(!Search(ans))break;
            int[] num = Enter(used);
            int i = num[0], j = num[1];
            if(ar[i][j] == '•' && ans[i][j] != '⬛'){
                System.out.println("------MISS------");
                ans[i][j] = '⬛';
                used = false;
            } else if(ans[i][j] == '⬛' || ans[i][j] == '+'){
                used = true;
                continue;
            } else if(ar[i][j] != '•'){
                if(ar[i][j] == '1'){
                    System.out.println("------SUNK------");
                    ar[i][j] = '+';
                    ans[i][j] = '+';
                    if(i > 1 && ans[i - 1][j] != '⬛')ans[i - 1][j] = '⚪';
                    if(i < 7 && ans[i + 1][j] != '⬛')ans[i + 1][j] = '⚪';
                    if(j > 1 && ans[i][j - 1] != '⬛')ans[i][j - 1] = '⚪';
                    if(j < 7 && ans[i][j + 1] != '⬛')ans[i][j + 1] = '⚪';
                    if(i > 1 && j > 1 && ans[i - 1][j - 1] != '⬛')ans[i - 1][j - 1] = '⚪';
                    if(i > 1 && j < 7 && ans[i - 1][j + 1] != '⬛')ans[i - 1][j + 1] = '⚪';
                    if(i < 7 && j > 1 && ans[i + 1][j - 1] != '⬛')ans[i + 1][j - 1] = '⚪';
                    if(i < 7 && j < 7 && ans[i + 1][j + 1] != '⬛')ans[i + 1][j + 1] = '⚪';
                } else if(ar[i][j] == '2'){
                    ar[i][j] = '+';
                    ans[i][j] = '+';
                    if(i > 1 && ans[i - 1][j] == '+') ans = ShipSunk2(ans, i, j, i - 1, j);
                    else if(i < 7 && ans[i + 1][j] == '+') ans = ShipSunk2(ans, i, j, i + 1, j);
                    else if(j > 1 && ans[i][j - 1] == '+') ans = ShipSunk2(ans, i, j, i, j - 1);
                    else if(j < 7 && ans[i][j + 1] == '+') ans = ShipSunk2(ans, i, j, i, j + 1);
                    else System.out.println("------HIT------");
                } else if(ar[i][j] == '3'){
                    System.out.println("------HIT3------");
                    ar[i][j] = '+';
                    ans[i][j] = '+';
                }
            }
            count ++;
            FieldOutput(ans);
        }
        System.out.println("You move " + count + " times!");
    }
}
