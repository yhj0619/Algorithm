import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Queue<Integer> queue = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        while(queue.size() > 1) { // 카드가 1개 남을 때까지
            queue.poll(); // 바닥에 버리기
            queue.add(queue.poll()); // 맨 뒤에 넣기
        }
        System.out.println(queue.peek());
    }
}
