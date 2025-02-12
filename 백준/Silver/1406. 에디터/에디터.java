import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        // 빠른 입출력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String initial = br.readLine();            // 초기 문자열
        int M = Integer.parseInt(br.readLine());    // 명령어 개수

        // 커서의 왼쪽 부분과 오른쪽 부분을 관리하는 두 개의 스택
        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();
        
        // 초기 문자열의 모든 문자를 왼쪽 스택에 삽입 (커서는 문자열의 끝에 위치)
        for (char ch : initial.toCharArray()) {
            leftStack.push(ch);
        }
        
        // 각 명령어 처리
        for (int i = 0; i < M; i++) {
            String command = br.readLine();
            char op = command.charAt(0);
            switch (op) {
                case 'L':  // 커서를 왼쪽으로 이동
                    if (!leftStack.isEmpty()) {
                        rightStack.push(leftStack.pop());
                    }
                    break;
                case 'D':  // 커서를 오른쪽으로 이동
                    if (!rightStack.isEmpty()) {
                        leftStack.push(rightStack.pop());
                    }
                    break;
                case 'B':  // 커서 왼쪽 문자 삭제
                    if (!leftStack.isEmpty()) {
                        leftStack.pop();
                    }
                    break;
                case 'P':  // 커서 위치에 문자 추가 ('P x' 형태)
                    char x = command.charAt(2);
                    leftStack.push(x);
                    break;
                default:
                    break;
            }
        }
        
        // 결과 문자열을 만들기 위한 StringBuilder
        StringBuilder sb = new StringBuilder();
        
        // 왼쪽 스택의 내용은 바닥부터 정상 순서대로 있으므로 그대로 append
        for (char ch : leftStack) {
            sb.append(ch);
        }
        
        // 오른쪽 스택은 커서와 가까운 문자가 top에 있으므로, pop하면 올바른 순서대로 문자가 나옴
        while (!rightStack.isEmpty()) {
            sb.append(rightStack.pop());
        }
        
        // 결과 출력
        System.out.println(sb.toString());
    }
}
