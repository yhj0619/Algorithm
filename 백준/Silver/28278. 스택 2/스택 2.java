import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack =new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            if(num == 1){
                int x = Integer.parseInt(st.nextToken());
                stack.push(x);
            }
            else if(num == 2){
                if(stack.isEmpty()){
                    sb.append("-1\n");
                } else{
                    sb.append(stack.pop()).append("\n");
                }
            } else if(num == 3){
                sb.append(stack.size()).append("\n");
            } else if(num == 4){
                if(stack.isEmpty()){
                    sb.append("1\n");
                } else{
                    sb.append("0\n");
                }
            }
            else if(num == 5){
                if(stack.isEmpty()){
                    sb.append("-1\n");
                } else{
                    sb.append(stack.peek()).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}