import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int w_max = 0;
        int h_max = 0;       
        
        for(int i = 0; i < sizes.length; i++){
            int w = Math.max(sizes[i][0], sizes[i][1]);
            int h = Math.min(sizes[i][0], sizes[i][1]);
            
            w_max = Math.max(w_max, w);
            h_max = Math.max(h_max, h);
        }
        return w_max * h_max;
    }
}