import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        System.out.println(pow(A,B,C));
    }

    public static long pow(int a, int b, int c) {
        if(b == 0)
            return 1;
        long n = pow(a, b / 2, c);
        if (b % 2 == 0)
            return n * n % c;
        else
            return (n * n % c) * a % c;
    }
}
