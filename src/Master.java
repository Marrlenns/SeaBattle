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
                            ar[i][j] = '*';
                            ar[i][j - 1] = '*';
                            ar[i][j + 1] = '*';
                            flag = false;
                        }
                    } else{
                        if(i > 1 && i < 7){
                            ar[i][j] = '*';
                            ar[i - 1][j] = '*';
                            ar[i + 1][j] = '*';
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
                            if(j > 2 && ar[i][j - 2] == '*')buffer = false;
                            else if(j < 7 && ar[i][j + 1] == '*')buffer = false;
                            else if((i > 1 && ar[i - 1][j] == '*') || (i > 1 && ar[i - 1][j - 1] == '*'))buffer = false;
                            else if(i > 1 && j > 2 && ar[i - 1][j - 2] == '*')buffer = false;
                            else if(j < 7 && i > 1 && ar[i - 1][j + 1] == '*')buffer = false;
                            else if(j < 7 && i < 7 && ar[i + 1][j + 1] == '*')buffer = false;
                            else if((i < 7 && ar[i + 1][j] == '*') || (i < 7 && ar[i + 1][j - 1] == '*'))buffer = false;
                            else if(j > 2 && i < 7 && ar[i + 1][j - 2] == '*')buffer = false;
                            if(buffer){
                                ar[i][j] = '*';
                                ar[i][j - 1] = '*';
                                flag = false;
                            }
                        } else if(j < 7 && ar[i][j] == '•' && ar[i][j + 1] == '•'){
                            boolean buffer = true;
                            if(j > 1 && ar[i][j - 1] == '*')buffer = false;
                            else if(j > 1 && i > 1 && ar[i - 1][j - 1] == '*')buffer = false;
                            else if((i > 1 && ar[i - 1][j] == '*') || (i > 1 && ar[i - 1][j + 1] == '*'))buffer = false;
                            else if(j < 6 && i > 1 && ar[i - 1][j + 2] == '*')buffer = false;
                            else if(j < 6 && ar[i][j + 2] == '*')buffer = false;
                            else if(j < 6 && i < 7 && ar[i + 1][j + 2] == '*')buffer = false;
                            else if((i < 7 && ar[i + 1][j] == '*') || (i < 7 && ar[i + 1][j + 1] == '*'))buffer = false;
                            else if(j > 1 && i < 7 && ar[i + 1][j - 1] == '*')buffer = false;
                            if(buffer){
                                ar[i][j] = '*';
                                ar[i][j + 1] = '*';
                                flag = false;
                            }
                        }
                    } else{
                        if(i > 1 && ar[i][j] == '•' && ar[i - 1][j] == '•'){
                            boolean buffer = true;
                            if(i > 2 && j > 1 && ar[i - 2][j - 1] == '*')buffer = false;
                            else if(i > 2 && ar[i - 2][j] == '*')buffer = false;
                            else if(i > 2 && j < 7 && ar[i - 2][j + 1] == '*')buffer = false;
                            else if((j < 7 && ar[i - 1][j + 1] == '*') || (j < 7 && ar[i][j + 1] == '*'))buffer = false;
                            else if(i < 7 && j < 7 && ar[i + 1][j + 1] == '*')buffer = false;
                            else if(i < 7 && ar[i + 1][j] == '*')buffer = false;
                            else if(i < 7 && j > 1 && ar[i + 1][j - 1] == '*')buffer = false;
                            else if((j > 1 && ar[i - 1][j - 1] == '*') || (j > 1 && ar[i][j - 1] == '*'))buffer = false;
                            if(buffer){
                                ar[i][j] = '*';
                                ar[i - 1][j] = '*';
                                flag = false;
                            }
                        } else if(i < 7 && ar[i][j] == '•' && ar[i + 1][j] == '•'){
                            boolean buffer = true;
                            if(i > 1 && j > 1 && ar[i - 1][j - 1] == '*')buffer = false;
                            else if(i > 1 && ar[i - 1][j] == '*')buffer = false;
                            else if(i > 1 && j < 7 && ar[i - 1][j + 1] == '*')buffer = false;
                            else if((j < 7 && ar[i + 1][j + 1] == '*') || (j < 7 && ar[i][j + 1] == '*'))buffer = false;
                            else if(i < 6 && j < 7 && ar[i + 2][j + 1] == '*')buffer = false;
                            else if(i < 6 && ar[i + 2][j] == '*')buffer = false;
                            else if(i < 6 && j > 1 && ar[i + 2][j - 1] == '*')buffer = false;
                            else if((j > 1 && ar[i + 1][j - 1] == '*') || (j > 1 && ar[i][j - 1] == '*'))buffer = false;
                            if(buffer){
                                ar[i][j] = '*';
                                ar[i + 1][j] = '*';
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
                    if(i > 1 && j > 1 && ar[i - 1][j - 1] == '*')buffer = false;
                    else if(i > 1 && ar[i - 1][j] == '*')buffer = false;
                    else if(i > 1 && j < 7 && ar[i - 1][j + 1] == '*')buffer = false;
                    else if(j < 7 && ar[i][j + 1] == '*')buffer = false;
                    else if(i < 7 && j < 7 && ar[i + 1][j + 1] == '*')buffer = false;
                    else if(i < 7 && ar[i + 1][j] == '*')buffer = false;
                    else if(i < 7 && j > 1 && ar[i + 1][j - 1] == '*')buffer = false;
                    else if(j > 1 && ar[i][j - 1] == '*')buffer = false;
                    if(buffer){
                        ar[i][j] = '*';
                        a4 --;
                    }
                }
            }
        }
        return ar;
    }

    public static boolean Search(char[][] ar){
        for(int i = 1; i < 8; i++){
            for(int j = 1; j < 8; j++){
                if(ar[i][j] == '*')return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter your name: ");
//        String s = scanner.nextLine();
        char[][] ar = SeaBattle();
        boolean flag = true;
        int count = 0;
        while(flag){
            if(!Search(ar))break;
            boolean ent = true;
            while(ent){
                String[] s = scanner.nextLine().split(" ");
                if(s.length == 2){
                    continue;
                }
            }
        }
    }
}