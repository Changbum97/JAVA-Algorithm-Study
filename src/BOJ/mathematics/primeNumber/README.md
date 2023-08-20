# 에라토스테네스의 체

- 2 ~ n 사이의 정수 중 소수를 구하는 방법 (1은 소수 X)
- boolean\[n + 1] isPrimeNumber 배열 생성
- 모두 true로 초기화 (마지막에 isPrimeNumber\[i]가 true이면 소수)
- i = 2부터 root(n)까지 돌면서 isPrimeNumber\[i]가 true인 경우 (i가 소수)에 i를 제외한 n이하의 i의 배수들을 모두 false로 변경

# 코드

```java
boolean[] isPrimeNumber = new boolean[n + 1];
Arrays.fill(isPrimeNumber, true);
isPrimeNumber[1] = false;

for (int i = 2 ; i * i <= n ; i ++) {
    if (isPrimeNumber[i]) {
        for (int j = i + i ; j <= n ; j += i) {
            isPrimeNumber[j] = false;
        }
    }
}

return isPrimeNumber;
```