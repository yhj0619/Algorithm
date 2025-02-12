import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> index = new Stack<>(); // top의 인덱스를 저장하는 스택임

        StringTokenizer st = new StringTokenizer(br.readLine()); //입력 배열

        StringBuilder sb = new StringBuilder(); //결과를 출력용

        for(int i = 1; i <= N; i++){
            int num = Integer.parseInt(st.nextToken());

            while(true) {
                if (!stack.isEmpty()) {
                    int top = stack.peek(); //top의 숫자
                    if (top > num) {
                        sb.append(index.peek()).append(" ");
                        stack.push(num);
                        index.push(i);
                        break;
                    } else {
                        stack.pop();
                        index.pop();
                    }
                } else { //stack이 비어있으면 어자피 수신할 게 없음.
                    sb.append("0 ");
                    stack.push(num);
                    index.push(i);
                    break;
                }
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
// stack : 6 9 5 7 4
// result : 0 0 2 2 4
//