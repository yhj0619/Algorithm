import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int[] arr = new int[9]; //0~8까지. 9는 6이랑 동일하기에.

        for(int i = 0; i < s.length(); i++){
            int num = s.charAt(i) - '0';

            if(num == 9){   //숫자 9-> 6번에 +1
                arr[6]++;
            } else {
                arr[num]++;
            }

        }

        // 6번 9번 모두 6번 배열로 들어갔으니 반으로 나눠주고, 나머지(=1) 더해줘야 함.
        arr[6] = (arr[6] / 2) + (arr[6] % 2);
        Arrays.sort(arr);   //오름차순으로 정렬
        System.out.println(arr[8]); //가장 큰 수 출력

    }
}
