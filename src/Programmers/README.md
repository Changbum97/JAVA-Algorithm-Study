# IDE 없는 코테 대비

## ArrayList 정렬

```java
List<Integer> temp = new ArrayList<>();

// 오름차순 정렬
Collections.sort(temp);
// 내림차순 정렬
Collections.sort(temp, Collections.reverseOrder());
```

## Queue, Stack

### Queue (FIFO)

```java
// 선언
Queue<Integer> queue = new LinkedList<>();
// 추가
queue.add(100);
// 추출
queue.poll();
// 조회
queue.peek();
```

### Stack (LIFO)

```java
// 선언
Stack<Integer> stack = new Stack<>();
// 추가
stack.push(100);
// 추출
stack.pop();
// 조회
stack.peek();
```

## Priority Queue

```java
// 선언
PriorityQueue<Integer> pq = new PriorityQueue<>();
// 추가
pq.add(100);
// 추출
pq.poll();
// 조회
pq.peek();
```

### Priority Queue 정렬 방법 수정 1 - Comparable 상속

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

### Priority Queue 정렬 방법 수정 2 - Comparator 사용

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

### MaxHeap, MinHeap

- MinHeap : 작은 수 부터 return (default)
- MaxHeap : 큰 수 부터 return

```java
PriorityQueue<Integer> minHeap = new PriorityQueue<>();
PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
```