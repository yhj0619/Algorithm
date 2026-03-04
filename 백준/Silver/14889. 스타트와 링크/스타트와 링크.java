import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[][] s;
    static boolean[] pick;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        s = new int[n][n];
        pick = new boolean[n];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                s[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        pick[0] = true;
        combi(1, 1);
        System.out.print(result);
    }
    static void combi(int index, int count){
        if(count == n/2){
            calc();
            return;
        }
        // 더 뽑을 사람이 부족하면 종료
        if(index >= n) return;

        // 조합: idx 사람을 뽑는다
        pick[index] = true;
        combi(index + 1, count + 1);

        // idx 사람을 안 뽑는다
        pick[index] = false;
        combi(index + 1, count);
    }
    static void calc(){
        int start = 0; int link = 0;

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(pick[i] && pick[j]){
                    start += s[i][j] + s[j][i];
                } else if(!pick[i] && !pick[j]){
                    link += s[i][j] + s[j][i];
                }
            }
        }
        result = Math.min(result, Math.abs(start-link));
    }
}
