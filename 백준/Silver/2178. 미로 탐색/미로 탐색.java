import java.io.*;
import java.util.*;

public class Main {
    private static final int[] dx = {-1, 0, 1, 0}; // x축
    private static final int[] dy = {0, 1, 0, -1}; // y축
    private static int[][] map; //입력값
    private static int N, M;
    private static boolean[][] visited; //각 칸을 방문했는지 확인하는 2차원 배열

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer input = new StringTokenizer(br.readLine());
        N = Integer.parseInt(input.nextToken());
        M = Integer.parseInt(input.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++){
            String inputLine = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = inputLine.charAt(j) - '0'; //아스키코드 정수로 전환
            }
        }

        visited = new boolean[N][M];
        visited[0][0] = true;
        bfs(0, 0);
        bw.write(map[N-1][M-1] + "\n");
        bw.flush();
        bw.close();
    }
    public static void bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>(); //bfs에 사용할 큐
        queue.add(new int[]{x, y});

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];

            for(int i = 0; i < 4; i++){
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M){
                    continue;
                }
                if(visited[nextX][nextY] || map[nextX][nextY] == 0){
                    continue;
                }
                queue.add(new int[]{nextX, nextY});
                map[nextX][nextY] = map[currentX][currentY] + 1;
                visited[nextX][nextY] = true;
            }
        }
    }
}
