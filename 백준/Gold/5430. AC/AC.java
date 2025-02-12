import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {

            String command = br.readLine(); // 명령어

            int n = Integer.parseInt(br.readLine());    // 배열 크기

            String arrStr = br.readLine();  // 배열을 문자열로 입력받음


            Deque<Integer> deque = new LinkedList<>();  // deque 선언

            // 배열이 비어있지 않으면 deque에 추가
            if (n > 0) {
                String[] nums = arrStr.substring(1, arrStr.length() - 1).split(",");
                for (String num : nums) {
                    deque.add(Integer.parseInt(num));
                }
            }

            boolean isReverse = false;
            boolean errorFlag = false;

            // 명령어 한 글자씩 처리
            // 명령어 처리용으로 deque이용
            for (int i = 0; i < command.length(); i++) {
                char op = command.charAt(i);
                if (op == 'R') {
                    // R 명령은 단순히 뒤집기 플래그
                    isReverse = !isReverse;
                } else if (op == 'D') {
                    // D 명령: deque가 비어있으면 error임. 아니면 앞 또는 뒤에서 삭제
                    if (deque.isEmpty()) {
                        errorFlag = true;
                        break;
                    }
                    if (isReverse) {
                        deque.removeLast();
                    } else {
                        deque.removeFirst();
                    }
                }
            }

            // 결과 출력
            if (errorFlag) {
                bw.write("error\n");
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("[");

                // isReverse에 따라 출력 순서를 결정
                //결과 출력 용 deque 함수 이용한 것
                if (isReverse) {
                    while (!deque.isEmpty()) {
                        sb.append(deque.removeLast());
                        if (!deque.isEmpty()) {
                            sb.append(",");
                        }
                    }
                } else {
                    while (!deque.isEmpty()) {
                        sb.append(deque.removeFirst());
                        if (!deque.isEmpty()) {
                            sb.append(",");
                        }
                    }
                }
                sb.append("]\n");
                bw.write(sb.toString());
            }
        }

        bw.flush();
        bw.close();
    }
}
