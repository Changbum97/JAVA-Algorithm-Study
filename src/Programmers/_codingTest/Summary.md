# 프로그래머스 코딩테스트 IDE 없는 경우 대비

## 길이

- String[] S가 주어진 경우
  - for (int i = 0 ; i < S.length ; i ++)
    - for (int j = 0 ; j < S\[i].length() ; j ++)

## List(ArrayList 정렬)

- List<Integer> xList = new ArrayList<>()를 정렬하는 경우
  - 오름차순 정렬 : Collections.sort(xList);
  - 내림차순 정렬 : Collections.sort(xList, Collections.reverseOrder());

## Solution 클래스 외의 다른 클래스, 전역 변수가 필요한 경우

- 전역 변수
  - Solution 클래스 내부의 solution 클래스 외부에 작성
  - static int x = 0;
- 다른 클래스
  - Solution 클래스 내부의 solution 클래스 외부에 작성
  - public int solve() { }