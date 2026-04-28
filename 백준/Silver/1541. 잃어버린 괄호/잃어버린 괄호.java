import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();


        // 마이너스 뒤에 숫자들을 다 묶어서 최대한 크게 만든 후 더하는게 최솟값임. 그래서 마이너스 기준으로!
        String[] minus = input.split("-");

        int result = 0;

        for(int i = 0; i < minus.length; i++){
            String[] plus = minus[i].split("\\+");

            int sum = 0;
            for(String s : plus)
                sum += Integer.parseInt(s);
            if(i == 0) result += sum; // 첫번째는 더하기
            else result -= sum; //나머지는 전부 빼기

            // (첫번째 숫자) - (나머지 다 더해!)
        }
        System.out.println(result);
    }
}
