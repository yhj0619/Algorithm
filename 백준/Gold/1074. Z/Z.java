import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int r, c, count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        Z(r, c, (int) Math.pow(2, N));
        bw.write(count + "\n");
        bw.flush();
        bw.close();
    }

    public static void Z(int x, int y, int size) {
        if (size == 1)
            return;

        int newSize = size / 2;
        if (x < newSize && y < newSize) {    //왼쪽 위
            Z(x, y, size / 2);
        } else if (x < newSize && newSize <= y) {    //오른쪽 위
            count += (size * size / 4);
            Z(x, y - newSize, newSize);
        } else if (x >= newSize && newSize > y) { //왼쪽 아래
            count += (size * size / 4) * 2;
            Z(x - newSize, y, newSize);
        } else {                        //오른쪽 아래
            count += (size * size / 4) * 3;
            Z(x - newSize, y - newSize, newSize);

        }
    }
}
