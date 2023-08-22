# Priority Queue

- 우선순위 큐
- Heap 구조
  - min-heap : 가장 낮은 우선순위가 앞에 배치 (default: 작은 값)
  - max-heap : 가장 높은 우선순위가 앞에 배치
- 시간복잡도
  - 삽입 : O(logN)
  - 삭제, 가져오기 : O(1)
  - 특정원소 탐색, 삭제 : O(N)

# 기본 코드

```java
// 선언
PriorityQueue<Integer> pq = new PriorityQueue<>();
// 삽입
pq.add();
// 추출
pq.peek();
// 삭제
pq.poll();
```

# MaxHeap, MinHeap

```java
PriorityQueue<Integer> minHeap = new PriorityQueue<>();
PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
```

# 우선 순위 조정 1 - Comparable 상속

```java
PriorityQueue<SW> pq2 = new PriorityQueue<>();

class SW implements Comparable<SW> {
    int start, workTime;

    SW (int start, int workTime) {
        this.start = start;
        this.workTime = workTime;
    }

    // workTime을 기준으로 오름차순 정렬
    // workTime이 같다면 start를 기준으로 내림차순 정렬
    public int compareTo(SW sw) {
        if (this.workTime == sw.workTime) {
            return sw.start - this.start;
        }
        return this.workTime - sw.workTime;
    }
}
```

# 우선 순위 조정 2 - Comparator 사용

```java
PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
    // S1 + S2, S2 + S1을 비교하여 결과가 크게 나오도록 return
    // ex) 6, 10 => 610 > 106 => 6이 앞에 오도록함
    @Override
    public int compare(String s1, String s2) {
        int x = Integer.parseInt(s1 + s2);
        int y = Integer.parseInt(s2 + s1);
        return y - x;
    }
});
```