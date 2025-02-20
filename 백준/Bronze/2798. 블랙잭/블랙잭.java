import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(search(arr, N, M));
    }
    public static int search(int[] arr, int N, int M){
        int result = 0;

        for(int i = 0; i < N-2; i++) {
            for(int j=i+1;j<N-1;j++){
                for(int k=j+1;k<N;k++){
                    int sum = arr[i] + arr[j] + arr[k];

                    if(sum == M) {
                        return sum;
                    }

                    if(result < sum && sum < M) {
                        result = sum;
                    }
                }
            }
        }
        return result;
    }
}
