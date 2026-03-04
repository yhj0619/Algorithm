import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int[] arr;
    static int[] operator = new int[4];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;


    static void dfs(int depth, int result){
        if(depth == n){
            max =  Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

        for(int i = 0; i <4; i++){
            if(operator[i] > 0){
                operator[i]--;
                if(i == 0){
                    dfs(depth + 1, result + arr[depth]);
                } else if(i == 1){
                    dfs(depth + 1, result - arr[depth]);
                } else if(i == 2){
                    dfs(depth + 1, result * arr[depth]);
                } else if(i == 3){
                    dfs(depth + 1, result / arr[depth]);
                }
                operator[i]++;
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++){
            operator[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, arr[0]);

        System.out.println(max);
        System.out.println(min);
    }

}
