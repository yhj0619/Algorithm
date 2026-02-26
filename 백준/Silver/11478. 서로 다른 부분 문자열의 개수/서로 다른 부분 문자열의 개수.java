import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        HashSet<String> set = new HashSet<>();

        for(int i = 0; i < s.length(); i++){
            StringBuilder sb = new StringBuilder();
            for(int j = i; j < s.length(); j++){
                sb.append(s.charAt(j));
                set.add(sb.toString());
            }
        }
        System.out.println(set.size());
    }
}
