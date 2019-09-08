### 중복이 없는가
- 기본적인 String 문제이다

```java
boolean[] check = new boolean[256];
```
- 문자열이 입력될 경우 해당 문자열을 0부터 확인하며 boolean 값을 true로 만든다. 그리고 해당 값이 이미 차있다면, 이미 이전에 문자가 존재하는 것이다.
