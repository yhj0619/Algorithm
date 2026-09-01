class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        int idx = 0; // 단어별 index

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == ' ') {
                answer.append(' ');
                idx = 0; // 단어 index 초기화
            } else {
                if (idx % 2 == 0) {
                    answer.append(Character.toUpperCase(c)); // 짝수 → 대문자
                } else {
                    answer.append(Character.toLowerCase(c)); // 홀수 → 소문자
                }
                idx++;
            }
        }
        return answer.toString();
    }
}
