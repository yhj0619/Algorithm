import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();
            boolean[] visited = new boolean[10];
            int count = 0;
            int answer = 0;
            int k = 1;

            while(count < 10){
                answer = n * k;

                int num = answer;

                while(num > 0){
                    int digit = num % 10;

                    if(!visited[digit]){
                        visited[digit] = true;
                        count++;
                    }
                    num /= 10;
                }
                k++;
            }

            System.out.println("#" + test_case + " " + answer);
        }
    }
}