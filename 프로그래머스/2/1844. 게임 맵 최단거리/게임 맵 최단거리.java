import java.util.*;

class Solution {

    //상하좌우
    int[] mX = {1, -1, 0, 0};
    int[] mY = {0, 0, 1, -1};

    public int solution(int[][] maps) {
        int answer = 0;

        int[][] visited = new int[maps.length][maps[0].length];

        bfs(maps, visited);

        answer = visited[maps.length - 1][maps[0].length - 1];

        if (answer == 0) {
            answer = -1;
        }

        return answer;
    }

    public void bfs(int[][] maps, int[][] visited) {
        // 시작 지점 방문 한 걸로
        int x = 0; 
        int y = 0;
        visited[x][y] = 1;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] now = queue.poll(); // 현재 위치를 큐에서 꺼냄
            int nX = now[0];
            int nY = now[1];

            // 상하좌우 탐색하기
            for (int i = 0; i < 4; i++) {
                int X = nX + mX[i];
                int Y = nY + mY[i]; 

                // 범위 벗어나는건 지나가기
                if (X < 0 || X >= maps.length || Y < 0 || Y >= maps[0].length) {
                    continue;
                }

                if (visited[X][Y] == 0 && maps[X][Y] == 1) {
                    visited[X][Y] = visited[nX][nY] + 1;
                    queue.add(new int[]{X, Y});
                }
            }
        }
    }
}
