import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;

        Map<String, Integer> map = new HashMap<String, Integer>();
        
        for (String[] name : clothes) {
            String clothType = name[1];
            map.put(clothType, map.getOrDefault(clothType, 0) + 1);
        }
        
        System.out.println(map); // Debugging: Map의 내용을 출력
        
        Iterator<Integer> iterator = map.values().iterator();
        
        while (iterator.hasNext()) {
            int value = iterator.next();
            System.out.println(value);
            answer *= (value + 1);      
            // 각 의상 종류별 선택할 수 있는 경우의 수를 곱함. 
            //이때 안입는 경우도 포함해서 +1 인것임.
        }
        
        answer -= 1; // 아무것도 입지 않는 경우 제외
        
        return answer;
    }
}
