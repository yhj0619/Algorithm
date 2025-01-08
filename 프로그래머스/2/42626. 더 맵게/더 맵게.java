//개같다 진짜하기싫어
import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        
        for(int s : scoville){
            heap.add(s);
        }
        
        int min = heap.peek();
        
        while(min < K){
            if(heap.size() >= 2){
                heap.add(heap.poll() + (heap.poll() * 2));
                min = heap.peek();
                answer ++;
            } else {
                return -1;
            }
        }
        
        return answer;
    }
}