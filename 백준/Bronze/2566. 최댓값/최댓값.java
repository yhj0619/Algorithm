import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
       Scanner sc = new Scanner(System.in);

        int max = Integer.MIN_VALUE;
        int i_flag = 1, j_flag = 1;

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                int num = sc.nextInt();
                if(max < num){
                    max = num;
                    i_flag = i + 1;
                    j_flag = j + 1;
                }
            }
        }
        System.out.println(max + "\n" + i_flag + " " + j_flag);
    }
}
