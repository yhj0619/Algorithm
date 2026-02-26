import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, String> map = new HashMap<>();

        for(int i = 1; i <= n; i++){
            String name = br.readLine();
            String idx = Integer.toString(i);
            map.put(name, idx);
            map.put(idx, name);
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < m; i++){
            sb.append(map.get(br.readLine())).append("\n");
        }
        System.out.print(sb);
    }
}