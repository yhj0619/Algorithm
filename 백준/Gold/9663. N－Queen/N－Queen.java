
import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int count = 0;

    static boolean[] col; //열 체크
    static boolean[] diag1; // ↘ 대각선 (row - col + n)
    static boolean[] diag2; // ↙ 대각선 (row + col)
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        col = new boolean[n];
        diag1 = new boolean[2*n];
        diag2 = new boolean[2*n];

        queen(0);

        System.out.println(count);
    }

    static void queen(int row){
        if(row == n){
            count++;
            return;
        }

        for(int i = 0; i < n; i++){
            if(!col[i] && !diag1[row - i + n] && !diag2[row + i]){
                col[i] = true;
                diag1[row - i + n] = true;
                diag2[row + i] = true;

                queen(row+1);

                col[i] = false;
                diag1[row - i + n] = false;
                diag2[row + i] = false;
            }

        }
    }
}
