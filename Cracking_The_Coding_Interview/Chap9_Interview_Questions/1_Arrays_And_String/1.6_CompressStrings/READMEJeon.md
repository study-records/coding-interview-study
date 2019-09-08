
# 문자열 압축하기
- 일단 아무리 효율적으로 작성해도 시간복잡도는 O(n) 이 최대이다.

## Algorithm
- pseudo code
> ```java
> String s;
> String compressed;
> int count = 0;
> for(each element in s){
> count ++; // Calc each duplicate characters
>  if(i== len-1) {
>    compressed += s(i) + count;
>	 break;
>  }
>   if(s(i) != s(i+1)){
>     compressed += s(i) + count;
>	count=0;
>   }   
> }
> print (compressed);
> ```

- 간단한 알고리즘이지만 실전에서 유용하게 쓰인다.
- 시간복잡도는 O(n)이며, java의 경우 StringBuilder를 사용하면 효율이 증가한다.
