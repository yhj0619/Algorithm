import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        int q = Integer.parseInt(br.readLine());

        int[][] sum = new int[26][s.length() + 1];
        for(int i = 1; i <= s.length(); i++){
            int idx = s.charAt(i - 1) - 'a';

            for(int j = 0; j < 26; j++){
                sum[j][i] = sum[j][i - 1];
            }

            sum[idx][i]++;
        }

        for(int i = 0; i < q; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int idx = c - 'a';

            int result = sum[idx][end + 1] - sum[idx][start];

            sb.append(result).append('\n');
        }

        System.out.print(sb);
    }
}