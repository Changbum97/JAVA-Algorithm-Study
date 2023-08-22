# Deque

- 큐의 양쪽으로 삽입, 삭제가 가능한 자료 구조

# 코드

```java
// 선언
Deque<Integer> deque = new ArrayDeque<>();
// 삽입
deque.addFirst();
deque.addLast();
// 삭제
deque.pollFirst();
deque.pollLast();
// 추출
deque.peekFirst();
deque.peekLast();
```