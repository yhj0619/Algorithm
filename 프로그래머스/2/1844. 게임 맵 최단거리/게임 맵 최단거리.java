import java.util.*;

class Solution {

    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        int[][] visited = new int[n][m];

        bfs(maps, visited);

        int answer = visited[n - 1][m - 1]; //도착 지점

        return answer == 0 ? -1 : answer;
    }

    public void bfs(int[][] maps, int[][] visited) {
        Queue<int[]> queue = new LinkedList<>();

        visited[0][0] = 1;
        queue.offer(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] now = queue.poll(); //큐의 맨 앞 요소를 꺼내면서 제거
            int x = now[0];
            int y = now[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= maps.length || ny >= maps[0].length) {
                    continue;
                }

                if (visited[nx][ny] == 0 && maps[nx][ny] == 1) {
                    visited[nx][ny] = visited[x][y] + 1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
    }
}