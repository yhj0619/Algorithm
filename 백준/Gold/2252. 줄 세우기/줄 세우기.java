import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] graph = new ArrayList[n+1];
        int[] indegree = new int[n+1];

        for(int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b); // a가 b 앞에
            indegree[b]++; // b 앞에 와야 하는 학생 수 증가
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i <= n; i++){
            if(indegree[i] == 0)
                queue.offer(i);
        }

        StringBuilder sb = new StringBuilder();

        while(!queue.isEmpty()){
            int current = queue.poll();

            sb.append(current).append(" ");

            for(int next : graph[current]){
                indegree[next]--;

                if(indegree[next] == 0){
                    queue.offer(next);
                }
            }
        }
        System.out.println(sb);
    }
}
