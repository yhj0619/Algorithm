import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int I;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
    static Queue<int[]> queue;
    static int endX, endY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            I = Integer.parseInt(br.readLine());
            map = new int[I][I];
            visited = new boolean[I][I];
            queue = new LinkedList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            endX = Integer.parseInt(st.nextToken());
            endY = Integer.parseInt(st.nextToken());

            bfs(startX,startY);

            bw.write( map[endX][endY]+ "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void bfs(int startX, int startY) {
        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;
        map[startX][startY] = 0;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];

            if(curX == endX && curY == endY) {
                break;
            }
            for(int i = 0; i < 8; i++) {
                int nX = curX + dx[i];
                int nY = curY + dy[i];

                if(nX >= 0 && nX < I && nY >= 0 && nY < I) {
                    if(!visited[nX][nY]) {
                        queue.add(new int[]{nX, nY});
                        visited[nX][nY] = true;

                        map[nX][nY] = map[curX][curY] + 1;
                    }
                }
            }
        }
    }
}
