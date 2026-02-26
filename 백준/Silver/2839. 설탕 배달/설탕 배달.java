import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int count5 = n / 5;

        while (count5 >= 0) {
            int left = n - (count5 * 5);

            if (left % 3 == 0) {
                int count3 = left / 3;
                System.out.println(count5 + count3);
                return;
            }

            count5--; // 5kg 하나 줄여보고 다시
        }

        System.out.println(-1);
    }
}
