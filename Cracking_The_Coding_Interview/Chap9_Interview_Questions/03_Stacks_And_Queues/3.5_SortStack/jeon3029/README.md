
StackSort
====

### 컴파일 방법 1)

0. current diretory : ~/jeon3029/.
1. javac src/*/*.java
2. java main/Solution stucture/Stack structure/StackArray

### Algorithm
- pseudo code(자료 Stack 1개 사용)
- 새로 만들어진 Stack은 항상 정렬된 상태 
- 기존 stack 을 S1, 정렬된 stack을 S2라 하자.
> 1. temp = S1. pop();
> 2. temp 가 들어갈 자리를 S2에서 찾음
>   2.1 S2에서 자료를 계속 pop하면서 S1에 넣어줌(count 번 반복)
> 3. 적절한 위치를 찾으면 S2.push(temp);
> 4. S1에 들어있는 기존 자료들을 S2에 다시 넣어줌(count 번 반복)