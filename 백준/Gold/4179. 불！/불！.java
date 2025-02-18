import java.io.*;
import java.util.*;

public class Main {
    private static final int[] dx = {-1, 0, 1, 0}; // x축 이동 방향
    private static final int[] dy = {0, 1, 0, -1}; // y축 이동 방향
    private static char[][] map;
    private static int[][] fireDist; // 불의 이동 시간
    private static int[][] personDist; // 지훈이의 이동 시간
    private static int R, C;
    private static Queue<int[]> queueFire = new LinkedList<>();
    private static Queue<int[]> queuePerson = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        fireDist = new int[R][C];
        personDist = new int[R][C];

        for (int i = 0; i < R; i++) {
            Arrays.fill(fireDist[i], -1); // -1로 초기화
            Arrays.fill(personDist[i], -1); // -1로 초기화
        }

        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = input.charAt(j);
                if (map[i][j] == 'J') {
                    queuePerson.add(new int[]{i, j});
                    personDist[i][j] = 0; // 지훈이 출발 지점
                } else if (map[i][j] == 'F') {
                    queueFire.add(new int[]{i, j});
                    fireDist[i][j] = 0; // 불의 시작 위치
                }
            }
        }

        spreadFire();

        int result = movePerson();
        if (result == -1) {
            bw.write("IMPOSSIBLE\n");
        } else {
            bw.write(result + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void spreadFire() {
        while (!queueFire.isEmpty()) {
            int[] current = queueFire.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
                if (map[nx][ny] == '#' || fireDist[nx][ny] != -1) continue; // 벽이거나 이미 불이면 패스

                fireDist[nx][ny] = fireDist[x][y] + 1;
                queueFire.add(new int[]{nx, ny});
            }
        }
    }

    public static int movePerson() {
        while (!queuePerson.isEmpty()) {
            int[] current = queuePerson.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                    return personDist[x][y] + 1; 
                }

                if (map[nx][ny] != '#' && personDist[nx][ny] == -1 &&
                        (fireDist[nx][ny] == -1 || personDist[x][y] + 1 < fireDist[nx][ny])) {

                    personDist[nx][ny] = personDist[x][y] + 1;
                    queuePerson.add(new int[]{nx, ny});
                }
            }
        }
        return -1;
    }
}
