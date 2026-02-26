import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i <n; i++){
            String s = br.readLine();
            Stack<Character> stack = new Stack<>();
            boolean isValid = true;
            for(char c : s.toCharArray()){
                if(c =='('){
                    stack.push(c);
                } else{
                    if(stack.isEmpty()){
                        isValid = false;
                        break;
                    }
                    stack.pop();
                }
            }
            if(!stack.isEmpty())
                isValid = false;
            sb.append(isValid ? "YES" : "NO").append("\n");
        }
        System.out.print(sb);
    }
}
