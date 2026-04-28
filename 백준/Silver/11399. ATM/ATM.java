import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] p = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            p[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(p);

        int sum = 0; // 현재 사람까지 걸린 누적 시간
        int answer = 0; // 모든 사람의 대기시간 합

        for(int i = 0; i < n; i++){
            sum += p[i];
            answer += sum;
        }
        System.out.println(answer);
    }
}