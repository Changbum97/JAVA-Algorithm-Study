# IDE 없는 코테 대비

## ArrayList 정렬

```java
List<Integer> temp = new ArrayList<>();

// 오름차순 정렬
Collections.sort(temp);
// 내림차순 정렬
Collections.sort(temp, Collections.reverseOrder());
```

## Array 정렬

```java
// 오름차순 정렬
int[] arr = new int[]{5, 3, 1, 2, 9};
Arrays.sort(arr);

// 내림차순 정렬 (int형은 안됨)
Integer[] arr = new Integer[]{5, 3, 1, 2, 9};
Arrays.sort(arr, Collectins.reverseOrder());

// Comparator을 사용하여 정렬 기준 설정
Integer[] arr = new Integer[]{5, 3, 1, 2, 9};
Arrays.sort(arr, new Comparator<Integer>() {
    @Override
    public int compare(Integer x, Integer y) {
        // 내림차순 정렬
        return y - x;
    }
})
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

## Map, Set

### HashMap

- Key, Value 존재
- Key 중복 불가

```java
// 선언
Map<String, Integer> map = new HashMap<>();
// 추가
map.put("a", 1);
// Key에 "a"가 있는지 확인
map.containsKey("a") == true
// Key가 "a"인 value
map.get("a")
// Key가 "a"인 데이터 삭제
map.remove("a")
// map -> array
map.keySet().toArray()
// map 순회
for (Map.Entry<String, Integer> entry : map.entrySet()) {
    System.out.println(entry.getKey() + " : " + entry.getValue());
}
// map의 Value만 순회
for (int value : map.values()) {
    answer += value;
}
```

### HashSet

- Value만 존재
- Value 중복 불가

```java
// 선언
Set<Integer> set = new HashSet<>();
// 추가
set.add(10);
// 삭제
set.remove(10);
// Set에 10이 있는지 체크
set.contains(10) == true
// iterator을 사용하여 Set 순회
Iterator<Integer> it = set.iterator();
while(it.hasNext()) {
    int i = it.next();
    System.out.println(i);
}
```