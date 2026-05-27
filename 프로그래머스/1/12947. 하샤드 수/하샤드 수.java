class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        
        int sum = 0;
        int temp = x;
        
        while(temp > 0){
            sum += temp % 10; // 마지막 자리 더하기
            temp /= 10; // 마지막 자리 제거
        }
        if(x % sum != 0){
            answer = false;
        }
        
        return answer;
    }
}