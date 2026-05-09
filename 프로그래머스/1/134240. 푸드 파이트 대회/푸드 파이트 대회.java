import java.util.*;

class Solution {
    public String solution(int[] food) {
        String answer = "";
        
        StringBuilder sb = new StringBuilder(); 
        for(int i = 1; i < food.length; i++){
            int count = food[i] / 2;
            
            for(int j = 0; j < count; j++){
                sb.append(i);
            }
        }
        answer = sb.toString();
        StringBuilder sb1 = new StringBuilder(sb);
        answer += "0";
        answer += sb1.reverse().toString();
        return answer;
    }
}