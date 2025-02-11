import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int mulp = Integer.parseInt(br.readLine())*Integer.parseInt(br.readLine())*Integer.parseInt(br.readLine());

        String str = Integer.toString(mulp);

        int[] arr = new int[10];

        for(int i = 0; i < str.length(); i++){
            arr[str.charAt(i) - '0']++;
        }
        for(int i = 0; i < 10; i++){
            System.out.println(arr[i]);
        }
    }
}
