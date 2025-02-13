import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));

        String s = br.readLine();

        Stack<Character> stack = new Stack<>();

        int result = 0;
        int temp = 1;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push('(');
                temp *= 2;
            } else if(s.charAt(i) == '['){
                stack.push('[');
                temp *= 3;
            } else if(s.charAt(i) == ')'){
                if(stack.isEmpty() || stack.peek() != '('){
                    result = 0;
                    break;
                } else if(s.charAt(i - 1) == '('){
                    result += temp;
                }
                stack.pop();
                temp /= 2;
            } else if(s.charAt(i) == ']'){
                if(stack.isEmpty() || stack.peek() != '['){
                    result = 0;
                    break;
                } else if(s.charAt(i - 1) == '['){
                    result += temp;
                }
                stack.pop();
                temp /= 3;
            }
        }
        if(!stack.isEmpty())
            bw.write("0\n");
        else bw.write(result + "\n");
        bw.flush();
        bw.close();
    }
}
