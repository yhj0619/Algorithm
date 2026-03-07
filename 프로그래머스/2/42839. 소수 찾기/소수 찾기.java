import java.util.*;

class Solution {
    static HashSet<Integer> set = new HashSet<>();
    static boolean[] visited;
    static boolean[] isPrime;

    public int solution(String numbers) {
        
        visited = new boolean[numbers.length()];
        
        dfs("", numbers, visited);
        //System.out.println("set 내용: " + set);
        
        int max = Collections.max(set);
        //System.out.println("max 값: " + max);
        
        isPrimeFunc(max);
        
        int count = 0;
        
        for(int num : set){
            //System.out.println("검사 숫자: " + num + " -> " + isPrime[num]);
            if(isPrime[num])
                count++;
        }
        return count;
    }
    
    static void dfs(String current, String numbers, boolean[] visited){
        if(!current.equals("")){
            set.add(Integer.parseInt(current));
            //System.out.println("생성된 숫자 : " + Integer.parseInt(current));
        }
        for(int i = 0; i < numbers.length(); i++){
            if(!visited[i]){
                visited[i] = true;
                // System.out.println("DFS 진행: " + current + " + " + numbers.charAt(i));
                
                dfs(current+numbers.charAt(i), numbers, visited);
                visited[i] = false;
            }
        }
    }
    
    static void isPrimeFunc(int max){
        isPrime = new boolean[max + 1];
        Arrays.fill(isPrime, true);
        
        isPrime[0] = isPrime[1] = false;
        
        for(int i = 2; i * i < max; i++){
            for(int j = i * i; j <= max; j += i){
                isPrime[j] = false;
            }
        }
    }
}