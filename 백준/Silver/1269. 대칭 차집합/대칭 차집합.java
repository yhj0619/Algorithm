import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashSet<Integer> aSet = new HashSet<>();
        HashSet<Integer> bSet = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            aSet.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            bSet.add(Integer.parseInt(st.nextToken()));
        }

        int cnt = 0;
        for(int num : aSet){
            if(!bSet.contains(num)){
                cnt++;
            }
        }
        for(int num : bSet){
            if(!aSet.contains(num)){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
