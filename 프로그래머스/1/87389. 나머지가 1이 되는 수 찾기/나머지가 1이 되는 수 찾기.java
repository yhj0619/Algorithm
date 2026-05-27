class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for(int i = 0; i < n; i++){
            if(n % (i+1) == 1){
                answer = (i+1);
                break;
            }
        }
        
        return answer;
    }
}