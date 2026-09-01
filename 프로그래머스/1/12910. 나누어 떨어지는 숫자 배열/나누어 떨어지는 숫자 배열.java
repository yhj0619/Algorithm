import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] arr, int divisor) {
        
        ArrayList<Integer> arrayList = new ArrayList<>();
        
        for(int i = 0; i < arr.length; i++){
            if(arr[i] % divisor == 0){
                arrayList.add(arr[i]);
            }
        }
        Collections.sort(arrayList);
        
        if(arrayList.isEmpty()){
            arrayList.add(-1);
        }
        return arrayList;
    }
}