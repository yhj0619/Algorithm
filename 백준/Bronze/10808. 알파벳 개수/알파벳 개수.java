import java.io.BufferedReader;
import java.io.InputStreamReader;

public class  Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int[] cnt = new int[26];
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            cnt[c - 97]++;
        }
        for(int i = 0; i < 26; i++){
            System.out.print(cnt[i] + " ");
        }

    }
}