class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int total = brown + yellow;
        
        for(int i = 3; i  < total; i++) {
            int row = total / i;
            
            if(row>= i){
                if( (i-2) * (row-2) == yellow){
                    answer[0] = row;
                    answer[1] = i;
                    break;
                }
            }
        }
        
        
        return answer;
    }
}