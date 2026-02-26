import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            String s = st.nextToken();

            for(int j = 0; j < s.length(); j++){
                char c =  s.charAt(j);
                for(int k = 0; k < num; k++) {
                    System.out.print(c);
                }
            }
            System.out.println();
        }
    }
}
