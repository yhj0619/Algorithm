import java.util.*;

class Solution {
    public int[] solution(int[] answers) {

        int[] one = {1,2,3,4,5};
        int[] two = {2,1,2,3,2,4,2,5};
        int[] three = {3,3,1,1,2,2,4,4,5,5};
        
        int[] scores = new int[3];
        for(int i = 0; i < answers.length; i++){
            if(answers[i] == one[i % one.length]) scores[0]++;
            if(answers[i] == two[i % two.length]) scores[1]++;
            if(answers[i] == three[i % three.length]) scores[2]++;
        }
                
        int max = Math.max(scores[0], Math.max(scores[1], scores[2]));
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < 3; i++){
            if(scores[i] == max){
                list.add(i+1);
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}