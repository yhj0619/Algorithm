import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));

        Stack<Character> stack = new Stack<>();
        String s = br.readLine();

        int count = 0; // 결과 출력

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push('(');
                
            } else if(s.charAt(i) == ')'){
                stack.pop();

                if(s.charAt(i - 1) == '(')
                    count += stack.size();
                else
                    count++;
            }
        }
        bw.write(count + "\n");
        bw.flush();
        bw.close();
    }
}
