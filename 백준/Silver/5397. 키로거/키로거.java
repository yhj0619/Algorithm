import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        for(int i = 0; i < num; i++){
            LinkedList<Character> list = new LinkedList<>();
            ListIterator<Character> iter = list.listIterator();

            for(char ch : br.readLine().toCharArray()){
                switch (ch) {
                    case '<':
                        if (iter.hasPrevious()) {
                            iter.previous();
                        }
                        break;
                    case '>':
                        if (iter.hasNext()) {
                            iter.next();
                        }
                        break;
                    case '-':
                        if (iter.hasPrevious()) {
                            iter.previous();
                            iter.remove();
                        }
                        break;
                    default:
                        iter.add(ch);
                        break;
                }
            }
            StringBuilder sb = new StringBuilder();
            for (char c : list) {
                sb.append(c);
            }
            bw.write(sb.toString() + "\n");
        }

        bw.flush();
        bw.close();
    }
}
