import java.util.*;
import java.io.*;

public class Main {

    static char[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while((s=br.readLine()) != null){
            int n = Integer.parseInt(s);

            int size = (int) Math.pow(3, n);
            arr = new char[size];
            for(int i = 0; i < size; i++){
                arr[i] = '-';
            }
            recursion(0, size);

            System.out.println(arr);
        }
    }
    static void recursion(int start, int length){
        if(length == 1)
            return;
        int part = length / 3;

        for(int i = start + part; i < start + 2 *part; i++){
            arr[i] = ' ';
        }
        recursion(start, part);
        recursion(start + 2 * part, part);
    }
}
