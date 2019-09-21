# CompressStrings(문자열 압축)

## Question
반복되는 문자의 개수를 세는 방식의 기본적인 문자열 압축 메서드를 작성하라. 
- '압축된' 문자열의 길이가 기존 문자열의 길이보다 길다면 기존 문자열을 반환해야 한다. 
- 문자열은 대소문자 알파벳(a~z)으로만 이루어져 있다.

__`Input:`__ aabccccaaa  __`Output:`__ a2b1c5a3

## Solution
main/Solution.java
```java
package src.main;
import src.comm.*;

public class Solution {

    public static void main(String[] args) {

        String test = "AAaabccccaaa";
        CompressStrings cs = new CompressStrings();
        
        System.out.println("결과: " + cs.compress(test));
    }
}
```

comm/CompressStrings.java
```java
package src.comm; 

public class CompressStrings {

    public String compress(String testStr) {
        String[] strArr = testStr.split("");
        StringBuilder resultStr = new StringBuilder();

        String currentStr = "";
        String nextStr = "";

        int cnt = 0;
        int strArrSize = strArr.length;

        for (int i = 0; i < strArrSize; i++) {
            cnt++;
            nextStr = (i == strArrSize - 1) ? null : strArr[i + 1];
            currentStr = strArr[i];

            if (nextStr == null || !currentStr.equals(nextStr)) {
                resultStr.append(currentStr + Integer.toString(cnt));
                cnt = 0;
            }
        }

        // 기존 문자열보다 길 경우 기존 문자열 반환
        return resultStr.length() > testStr.length() ? testStr : resultStr.toString();
    }
}
```

## Execute
>경로이동

```
cd ./Cracking_The_Coding_Interview/Chap9_Interview_Questions/01_Arrays_And_String/1.6_CompressStrings/lqqokim/
```

>컴파일
```
javac -encoding UTF-8 -d ./ ./src/main/solution.java
```    
>실행
```
java src.main.solution
```
  - **경로이동**은 컴파일과 실행하기 위한 과정이며, 이동은 한번이면 됩니다.
  - **컴파일**, **실행**은 이미 경로를 이동하였다면 **경로이동**은 생략해도 됩니다.

## Note
- String, StringBuffer, StringBuilder의 차이와 특징

    https://cjh5414.github.io/why-StringBuffer-and-StringBuilder-are-better-than-String/
- 문자열 알고리즘 관련하여 StringBuilder append() 활용