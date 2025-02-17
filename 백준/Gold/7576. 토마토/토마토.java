import java.io.*;
import java.util.*;

public class Main {
    private static final int[] dx = {-1, 0, 1, 0}; // x축 이동 방향
    private static final int[] dy = {0, 1, 0, -1}; // y축 이동 방향
    private static int[][] map;
    private static int N, M;
    private static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer input = new StringTokenizer(br.readLine());
        M = Integer.parseInt(input.nextToken()); // M: 가로(열)
        N = Integer.parseInt(input.nextToken()); // N: 세로(행)

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            input = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(input.nextToken());
                if (map[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        bw.write(bfs() + "\n");
        bw.flush();
        bw.close();
    }

    public static int bfs() {
        int days = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 0) {
                    queue.add(new int[]{nx, ny});
                    map[nx][ny] = map[x][y] + 1;
                }
            }
        }

        int maxDays = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    return -1; // 익지 않은 토마토가 남아 있으면 -1 반환
                }
                maxDays = Math.max(maxDays, map[i][j]);
            }
        }

        return maxDays - 1; // 초기 익은 토마토가 1이므로 -1 해야 실제 날짜 계산
    }
}
