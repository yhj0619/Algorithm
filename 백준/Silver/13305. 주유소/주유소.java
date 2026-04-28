import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[] distance = new long[n - 1];
        long[] price = new long[n];

        StringTokenizer st =  new StringTokenizer(br.readLine());
        for(int i = 0; i < n-1; i++){
            distance[i] = Long.parseLong(st.nextToken());
        }

        st =  new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            price[i] = Long.parseLong(st.nextToken());
        }

        long minPrice = price[0];
        long total = 0;

        for(int i = 0; i < n-1; i++){
            if(price[i] < minPrice){
                minPrice = price[i];
            }
            total += minPrice * distance[i];
        }
        System.out.println(total);
    }
}
