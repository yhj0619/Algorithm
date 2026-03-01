import java.util.*;
import java.io.*;

public class Main {

    static int k;
    static int count = 0;
    static int result = -1;
    static int[] temp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        temp = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        merge_sort(arr, 0, n-1);
        System.out.println(result);
    }
    static void merge_sort(int[] arr, int p, int r){
        if(p < r){
            int q = Math.abs((p + r) / 2);
            merge_sort(arr, p, q);
            merge_sort(arr, q + 1, r);
            merge(arr, p, q, r);
        }
    }
    static void merge(int[] arr, int p, int q, int r){
        int i = p;
        int j = q+1;
        int t = 0;

        while(i <= q && j <= r){
            if(arr[i] <= arr[j]) temp[t++] = arr[i++];
            else temp[t++] = arr[j++];
        }
        while(i <= q) temp[t++] = arr[i++];
        while(j <= r) temp[t++] = arr[j++];

        i = p;
        t = 0;
        while(i <= r){
            count++;
            if(count == k){
                result = temp[t];
                return; // K번째 찾았으면 더 볼 필요 없음
            }
            arr[i++] = temp[t++];
        }
    }
}
