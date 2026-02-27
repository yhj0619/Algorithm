import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<Integer> stack = new Stack<>();
        int expected = 1;

        for(int i=0; i < n; i++){

            int num = Integer.parseInt(st.nextToken());

            if(num == expected){
                expected++;

                while (!stack.isEmpty() && stack.peek() == expected) {
                    stack.pop();
                    expected++;
                }
            } else{
                stack.push(num);
            }
            while (!stack.isEmpty() && stack.peek() == expected) {
                stack.pop();
                expected++;
            }
        }
        if (expected == n + 1) {
            System.out.println("Nice");
        } else {
            System.out.println("Sad");
        }
    }
}
