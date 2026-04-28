import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] time = new int[n][2];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            time[i][0] = Integer.parseInt(st.nextToken()); // 시작
            time[i][1] = Integer.parseInt(st.nextToken()); // 끝 시간
        }

        Arrays.sort(time, (a,b) -> {
           if(a[1] == b[1])
               return a[0] - b[0];
           return a[1] - b[1];
        });

        int count = 0;
        int endTime = 0;

        for(int i = 0; i < n; i++){
            if(time[i][0] >= endTime){
                count++;
                endTime = time[i][1];
            }
        }
        System.out.println(count);
    }
}
