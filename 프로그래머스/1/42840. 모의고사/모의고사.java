import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int a = 0; 
        int b = 0; 
        int c = 0;
        
        for(int i=0; i < answers.length; i++){
           if(answers[i] == one[i % one.length]) a++;
           if(answers[i] == two[i % two.length]) b++;
           if(answers[i] == three[i % three.length]) c++;       
        }
        
        int max= Math.max(Math.max(a, b), c);
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        if(max == a)
            result.add(1);
        if(max == b)
            result.add(2);
        if(max == c)
            result.add(3);
        
        int[] answer = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            answer[i] = result.get(i);            
        }
        
        return answer;
    }
}