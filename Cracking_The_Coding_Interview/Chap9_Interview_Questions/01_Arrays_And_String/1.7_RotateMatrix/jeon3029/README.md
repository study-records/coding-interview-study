# 행렬 회전하기
- 사실 이러한 유형의 문제는 string과 크게 관련이 없긴 하다.
- 시간복잡도는 모든 원소를 접근해햐 하므로 최소 O(n*m)이다.
- 하지만 공간복잡도를 최소화할 수 있다.

## 1. 공간복잡도 : n*m
- Solution은 해당 알고리즘으로 작성되었다.
### Algorithm
- pseudo code
>```java
>int matrix[n][m];
>int rotate[n][m];
>for (0~n-1 : i){
>  for(0~n-1 : j){
>    rotate[i][j] = matrix[n-j-1][i];
>    }
> }
>```
## 2. 공간복잡도 : X
- layer를 설정해서 바깥원소부터 차례대로 옮겨준다.
- EX) 1행 -> n열 / n열 -> n행 / n행 -> 1열
- 그리고 다음 layer
### Algorithm
- pseudo code
> ```java
>  int [][] matrix;
>  int len = matrix.length();
>  for(int layer = 0; layer<len/2;layer++){
>    int first = layer;
>    int last = n-1-layer;
>    for(int i=first;i<last;i++){
>  	 int offset = i-first;
>       int top = matrix[first][i]; //임시 저장
>       matrix[first][i] = matrix[last-offset][first];
> 	  martix[last-offset][first] = matrix[last][last-offset];
>       matrix[last][last-offset] = matrix[i][last];
>       matrix[i][last] = top;
>    }
>  }
> ```
