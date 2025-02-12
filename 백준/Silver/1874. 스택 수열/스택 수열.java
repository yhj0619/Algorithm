import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();

        int current = 1; // 다음에 push할 숫자

        for(int i = 0; i < n; i++){
            int target = Integer.parseInt(br.readLine());

            while(current <= target){ //현재 숫자와 stack에 넣으려는 숫자랑 비교해서 넣어야 함.
                stack.push(current++);
                sb.append("+\n");
            }
            if(stack.peek()== target && !stack.isEmpty()) {
                stack.pop();
                sb.append("-\n");
            } else {
                bw.write("NO\n");
                bw.flush();
                bw.close();
                return;
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
// stack: 1 2 5
// result: 4 3 6 8 7 5 2 1