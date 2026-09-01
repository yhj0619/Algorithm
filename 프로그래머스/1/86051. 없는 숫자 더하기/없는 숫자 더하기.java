class Solution {
    public int solution(int[] numbers) {
        int answer = -1;
        
        int sum = 0;
        
        for(int i = 0; i < 10; i++){
            sum += i;
        }
        
        int arrSum = 0;
        for(int i = 0; i < numbers.length; i++){
            arrSum += numbers[i];
        }
        
        return sum - arrSum;
    }
}