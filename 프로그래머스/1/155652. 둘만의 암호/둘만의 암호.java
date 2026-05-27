class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            int count = 0;
            
            while(count < index){
                if(ch == 'z'){
                    ch = 'a';
                } else{
                    ch++;
                }
                
                if(!skip.contains(String.valueOf(ch))){
                    count++;
                }
            }
            answer += ch;
        }
        
        return answer;
    }
}