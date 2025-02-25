import java.io.*;

public class Main {
    static int K = 0 ;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        hanoi(N, 1 ,2,3);
        System.out.println(K);
        System.out.println(sb);
    }

    public static void hanoi(int n, int start, int temp, int end) {
        if(n == 0) {
            return;
        } else {
            K++;
            hanoi(n - 1, start, end, temp);
            sb.append(start + " " + end + "\n");
            hanoi(n - 1, temp, start, end);
        }
    }
}
