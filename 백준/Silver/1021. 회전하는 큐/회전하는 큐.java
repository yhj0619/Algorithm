import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        LinkedList<Integer> deque = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int count = 0; // 결과 출력

        for(int i = 0; i < N; i++){
            deque.add(i+1);
        }

        st = new StringTokenizer(br.readLine());
        int[] nums = new int[M];
        for(int i = 0; i < M; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < M; i++){
            int baselineIndex = 0;
            int targetIndex = deque.indexOf(nums[i]);

            if(deque.size() % 2 == 0){
                baselineIndex = deque.size()/2 -1;
            }else{
                baselineIndex = deque.size()/2;
            }

            if(targetIndex <= baselineIndex){
                for(int j = 0; j < targetIndex; j++){
                    deque.addLast(deque.removeFirst());
                    count++;
                }
            } else{
                for(int j=0;j<deque.size()-targetIndex;j++){
                    deque.addFirst(deque.removeLast());
                    count++;
                }
            }
            deque.removeFirst();
        }
        System.out.println(count);
    }
}