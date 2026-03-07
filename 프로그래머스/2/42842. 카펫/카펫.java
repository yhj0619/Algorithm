class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        // width * height = brown + yellow
        // yellow = (width - 2) * (height - 2)
        
        int total = brown + yellow;
        
        for(int height = 3; height <= total; height++){
            if(total % height != 0)
                continue;
            
            int width = total / height;
            
            if((width - 2)  * (height - 2) == yellow){
                return new int[]{width, height};
            }
        }
        
          
        return new int[]{};
    }
}