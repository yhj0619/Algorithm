import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int count = 0; // 결과 출력
        for(int i=0; i<N; i++){
            String s = br.readLine();

            Stack<Character> stack = new Stack<>();
            stack.push(s.charAt(0));

            for(int j = 1; j < s.length(); j++){
                if(!stack.isEmpty() && stack.peek() == s.charAt(j)){
                    stack.pop();
                } else {
                    stack.push(s.charAt(j));
                }
            }
            if(stack.isEmpty()) count++;
        }
        System.out.println(count);
    }
}
