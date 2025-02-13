import java.io.*;
import java.util.*;

public class Main {
    private static final int[] dx  = {-1, 0, 1, 0}; // x축
    private static final int[] dy  = {0, 1, 0, -1}; // y축
    private static int[][] map;
    private static boolean[][] visited;
    private static Queue<int []> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<map.length; i++){
            String[] temp = br.readLine().split(" ");
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }

        List<Integer> list = new ArrayList<>();

        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[0].length; j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    int area = bfs(i,j);
                    list.add(area);
                }
            }
        }

        Collections.sort(list);
        bw.write(list.size()+ "\n");

        if(list.isEmpty()){
            bw.write("0\n");
        } else{
            bw.write(list.get(list.size()-1)+"\n");
        }

        bw.flush();
        bw.close();
    }
    public static int bfs(int x, int y){
        queue.add(new int[]{x,y});
        visited[x][y] = true;
        int sum = 1;

        while(!queue.isEmpty()){
            int[] temp = queue.poll(); //poll() == remove()
            for(int i = 0; i < 4; i++){
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];

                if(nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length) {
                    continue;
                }

                if(map[nx][ny] == 1 && !visited[nx][ny]){
                    queue.add(new int[]{nx,ny});
                    visited[nx][ny] = true;
                    sum++;
                }
            }
        }
        return sum;
    }
}
