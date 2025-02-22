import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int N;
    static char[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            String st = br.readLine();
            for(int j = 0; j < N; j++) {
                map[i][j] = st.charAt(j);
            }
        }

        int count = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    bfs(i, j);
                    count++;
                }
            }
        }
        bw.write(count + " ");

        visited = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == 'G')
                    map[i][j] = 'R';
            }
        }
        count=0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    bfs(i, j);
                    count++;
                }
            }
        }

        bw.write(count + "\n");
        bw.flush();
        bw.close();
    }

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];

            for(int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(!visited[nx][ny] && map[nx][ny] == map[curX][curY]) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }

            }
        }
    }
}
