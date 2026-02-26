import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int maxMoney = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] dice = new int[4];
            for (int j = 0; j < 4; j++) {
                dice[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(dice);

            int a = dice[0];
            int b = dice[1];
            int c = dice[2];
            int d = dice[3];

            int money;

            // 4개 같음
            if (a == d) {
                money = 50000 + a * 5000;

                // 3개 같음
            } else if (a == c || b == d) {
                int x = (a == c) ? a : b;
                money = 10000 + x * 1000;

                // 2쌍
            } else if (a == b && c == d) {
                money = 2000 + a * 500 + c * 500;

                // 1쌍
            } else if (a == b || b == c || c == d) {
                int x = (a == b) ? a : (b == c) ? b : c;
                money = 1000 + x * 100;

                // 모두 다름
            } else {
                money = d * 100;
            }

            maxMoney = Math.max(maxMoney, money);
        }

        System.out.println(maxMoney);
    }
}