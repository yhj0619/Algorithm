class Solution {
    public int solution(String s) {
        int answer = 0;
        
        int same = 0;
        int diff = 0;
        
        char x = s.charAt(0);
        
        for(int i = 0; i < s.length(); i++){
            if(same == 0 && diff == 0){
                x = s.charAt(i);
            }
            
            if(x == s.charAt(i)){
                same++;
            } else{
                diff++;
            }
            
            if(same == diff){
                answer++;
                same = 0;
                diff = 0;
            }
        }
        
        //남은글자
        if(same != 0 || diff != 0){
            answer++;
        }
        
        return answer;
    }
}