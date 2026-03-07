import java.util.*;
import java.io.*;

public class Main {

    static int[][] graph; // 인접행렬로
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        graph = new int[n+1][n+1];
        visited = new boolean[n+1];

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        dfs(n, v);
        sb.append("\n");

        visited = new boolean[n+1];
            bfs(n, v);

        System.out.println(sb);

    }

    static void dfs(int n, int v){
        visited[v] = true; // 시작점이 주어져~~~~~
        sb.append(v).append(" ");

        for(int i = 1; i <= n; i++){
            if(graph[v][i] == 1 && !visited[i]){
                dfs(n, i);
            }
        }
    }
    static void bfs(int n, int v){
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        visited[v] = true;

        while(!q.isEmpty()){
            int now = q.poll();
            sb.append(now).append(" ");

            for(int i = 1; i <= n; i++){
                if(graph[now][i] ==1 && !visited[i]){
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
