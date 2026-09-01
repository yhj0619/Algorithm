class Solution {
    public String solution(String phone_number) {
        String answer = "";
        
        char[] c_arr = phone_number.toCharArray();
        
        for(int i = 0; i < c_arr.length - 4; i++){
            c_arr[i] = '*';
        }
        for(int i = 0; i < c_arr.length; i++){
            answer += c_arr[i];
        }
        return answer;
    }
}