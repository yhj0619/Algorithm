import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            if(num == 1){
                int x = Integer.parseInt(st.nextToken());
                deque.offerFirst(x);
            }
            else if(num == 2){
                int x = Integer.parseInt(st.nextToken());
                deque.offerLast(x);
            } else if(num == 3){
                sb.append(deque.isEmpty() ? -1 : deque.pollFirst()).append("\n");

            } else if(num == 4){
                sb.append(deque.isEmpty() ? -1 : deque.pollLast()).append("\n");
            }
            else if(num == 5){
                sb.append(deque.size()).append("\n");
            } else if(num == 6){
                sb.append(deque.isEmpty() ? 1 : 0).append("\n");
            } else if(num == 7){
                sb.append(deque.isEmpty() ? -1 : deque.peekFirst()).append("\n");
            } else if(num == 8){
                sb.append(deque.isEmpty() ? -1 : deque.peekLast()).append("\n");
            }
        }
        System.out.println(sb);
    }
}