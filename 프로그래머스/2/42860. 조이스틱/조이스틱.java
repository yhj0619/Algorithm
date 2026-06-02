import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0;
        
        int len = name.length();
        
        int move = len - 1; // 기본 : 오른쪽으로 쭉 이동
        
        for(int i = 0; i < len; i++){
            char c = name.charAt(i);
            
            answer += Math.min(c - 'A', 'Z' - c + 1);
            
            int next = i + 1;
            while(next < len && name.charAt(next) == 'A'){
                next++;
            }
            move = Math.min(move, i*2+len-next);
            move = Math.min(move, (len-next) * 2 + i);
        }
        
        return answer + move;
    }
}