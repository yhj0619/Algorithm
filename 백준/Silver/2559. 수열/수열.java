import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] sum = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            sum[i] = sum[i-1] + Integer.parseInt(st.nextToken());
        }
        int max = Integer.MIN_VALUE;
        for (int i = k; i <= n; i++) {
            int cur = sum[i] - sum[i-k];
            max = Math.max(max, cur);
        }
        System.out.println(max);
    }
}
