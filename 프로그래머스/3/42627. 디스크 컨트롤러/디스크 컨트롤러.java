import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        // 1. 요청 시간 기준으로 정렬
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        // jobs 배열을 요청 시간(jobs[i][0]) 오름차순으로 정렬.
        // 이렇게 해야 요청이 들어온 순서대로 처리 가능.

        // 2. 작업 소요 시간 기준으로 정렬할 우선순위 큐 생성
        PriorityQueue<int[]> diskController = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        // 우선순위 큐는 작업 소요 시간(jobs[i][1])이 짧은 작업부터 처리.
        // 현재 처리 가능한 작업들 중 가장 빨리 끝나는 작업을 우선 처리하기 위해 사용.

        int index = 0; // jobs 배열을 순회하기 위한 인덱스.
        int count = 0; // 처리한 작업의 개수.
        int total = 0; // 모든 작업의 대기 시간 + 실행 시간의 총합.
        int end = 0;   // 현재 시간(작업이 끝난 시간).

        while (count < jobs.length) { 
            // 모든 작업(jobs.length)이 처리될 때까지 반복.

            // 3. 현재 시간(end)까지 요청된 모든 작업을 우선순위 큐에 추가
            while (index < jobs.length && jobs[index][0] <= end) {
                diskController.add(jobs[index++]); 
                // 현재 시간 이전에 요청된 작업을 우선순위 큐에 추가하고 인덱스 증가.
            }

            // 4. 만약 처리할 작업이 없다면, 현재 시간을 다음 작업의 요청 시간으로 이동
            if (diskController.isEmpty()) {
                end = jobs[index][0]; 
                // 우선순위 큐가 비어 있으면, 다음 요청 시간으로 end를 업데이트.
            } else {
                // 5. 처리 가능한 작업이 있을 경우, 우선순위 큐에서 가장 짧은 작업을 꺼내 처리
                int[] cur = diskController.poll(); 
                // 현재 작업을 큐에서 꺼냄 (작업 소요 시간이 가장 짧은 작업).
                total += cur[1] + end - cur[0]; 
                // 총합 = 현재 작업의 소요 시간(cur[1]) + 대기 시간(end - cur[0]).
                end += cur[1]; 
                // 현재 시간을 작업이 끝난 시간으로 업데이트.
                count++; 
                // 처리한 작업 수 증가.
            }
        }

        // 6. 평균 반환
        return total / jobs.length; 
        // 평균 대기 시간을 반환.
    }
}
