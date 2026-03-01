import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();
        int[] arr = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 1; i <= n; i++){
            deque.offerLast(i);
        }

        StringBuilder sb = new StringBuilder();
        while(!deque.isEmpty()){
            int cur = deque.pollFirst();
            sb.append(cur).append(" ");

            if(deque.isEmpty()) break;

            int j = arr[cur];

            if(j > 0){
                for(int i = 0; i < j - 1; i++){
                    deque.offerLast(deque.pollFirst());
                }
            } else{
                for(int i = 0; i < -j; i++){
                    deque.offerFirst(deque.pollLast());
                }
            }
        }
        System.out.println(sb);
    }
}
