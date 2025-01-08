import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        HashMap<String, Integer> genresTotal = new HashMap<>(); // 각 장르의 총 재생 횟수
        HashMap<String, HashMap<Integer, Integer>> playMap = new HashMap<>(); 
        // 각 장르마다 노래와 재생 횟수
        
        for (int i = 0; i < plays.length; i++) {
            if (!genresTotal.containsKey(genres[i])) {
                HashMap<Integer, Integer> song = new HashMap<>(); // 노래와 재생 횟수
                song.put(i, plays[i]);
                playMap.put(genres[i], song);
                genresTotal.put(genres[i], plays[i]);
            } else {
                playMap.get(genres[i]).put(i, plays[i]);
                genresTotal.put(genres[i], genresTotal.get(genres[i]) + plays[i]);
            }
        }
        
        // 장르별 총 재생 횟수에 따라 정렬
        ArrayList<String> keySet = new ArrayList<>(genresTotal.keySet());
        Collections.sort(keySet, (s1, s2) -> genresTotal.get(s2) - genresTotal.get(s1));
        
        for (String key : keySet) {
            HashMap<Integer, Integer> map = playMap.get(key);
            List<Integer> genreKeys = new ArrayList<>(map.keySet());
            
            // 노래별 재생 횟수에 따라 정렬
            Collections.sort(genreKeys, (s1, s2) -> map.get(s2) - map.get(s1));
            
            answer.add(genreKeys.get(0)); // 1등 추가
            if (genreKeys.size() > 1) {
                answer.add(genreKeys.get(1)); // 2등 추가 (있을 경우)
            }
        }
        
        // ArrayList를 int 배열로 변환하여 반환
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
