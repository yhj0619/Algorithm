import java.util.*;

class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        
        int length = myString.length();
        
        
        String replaceStr = myString.replace('A', 'X').replace('B', 'A').replace('X', 'B');
        
        if(replaceStr.contains(pat)){
            answer = 1;
        } else{
            answer = 0;
        }
        
        return answer;
    }
}