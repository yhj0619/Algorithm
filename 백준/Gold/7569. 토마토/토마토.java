import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, H;
    static int[][][] map;
    static int[] dx = {-1, 0, 1, 0, 0, 0};
    static int[] dy = {0, -1, 0, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());  // col 가로
        N = Integer.parseInt(st.nextToken());  // rows 세로
        H = Integer.parseInt(st.nextToken());  // height 높이

        map = new int[H][N][M];

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    map[h][n][m] = Integer.parseInt(st.nextToken());
                    if (map[h][n][m] == 1) {
                        queue.add(new int[]{h, n, m});
                    }
                }
            }
        }
        bw.write(bfs() + "\n");
        bw.flush();
        bw.close();
    }

    public static int bfs() {
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curH = cur[0], curN = cur[1], curM = cur[2];

            for (int i = 0; i < 6; i++) {
                int nH = curH + dz[i];
                int nN = curN + dx[i];
                int nM = curM + dy[i];

                if (nH >= 0 && nN >= 0 && nM >= 0 && nH < H && nN < N && nM < M && map[nH][nN][nM] == 0) {
                    queue.add(new int[]{nH, nN, nM});
                    map[nH][nN][nM] = map[curH][curN][curM] + 1;
                }
            }
        }

        int maxDays = 0;
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (map[h][n][m] == 0) {
                        return -1;
                    }
                    maxDays = Math.max(maxDays, map[h][n][m]);
                }
            }
        }

        if (maxDays == 1) {
            return 0;
        } else {
            return maxDays - 1;
        }
    }
}