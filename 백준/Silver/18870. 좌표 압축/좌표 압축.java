import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        int[] sorted = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sorted[i] = arr[i];
        }

        Arrays.sort(sorted);

        HashMap<Integer, Integer> map = new HashMap<>();
        int index = 0;

        for(int i = 0; i < n; i++){
            if(!map.containsKey(sorted[i])){
                map.put(sorted[i], index++);
            }
        }

        StringBuilder sb= new StringBuilder();
        for(int i = 0; i < n; i++){
            sb.append(map.get(arr[i]) + " ");
        }

        System.out.println(sb);
    }
}
