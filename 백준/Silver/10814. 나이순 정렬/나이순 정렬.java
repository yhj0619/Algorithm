import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        List<String[]> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());

            list.add(new String[]{st.nextToken(), st.nextToken()});
        }

        list.sort((n1, n2)-> {
           if(!n1[0].equals(n2[0])){
               return Integer.parseInt(n1[0]) - Integer.parseInt(n2[0]);
           } else{
               return 0;
           }
        });

        for(String[] l : list){
            sb.append(l[0]).append(' ').append(l[1]).append(' ').append('\n');
        }
        System.out.println(sb);
    }
}
