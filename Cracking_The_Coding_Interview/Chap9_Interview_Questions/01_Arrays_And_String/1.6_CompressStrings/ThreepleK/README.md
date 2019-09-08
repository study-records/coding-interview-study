
# 구동방법

> **01. 경로이동**
> -- 
    cd ./Cracking_The_Coding_Interview/Chap9_Interview_Questions/01_Arrays_And_String/1.6_CompressStrings/ThreepleK/
> **02. 컴파일**
> --
    javac -encoding UTF-8 -d ./ ./src/main/Index.java
> **03. 실행**
> --
    java app.main.Index
  - **01. 경로이동**은 컴파일과 실행하기 위한 과정이며, 이동은 한번이면 됩니다.
  - **02 .컴파일**, **03. 실행**은 이미 경로를 이동하였다면 **01. 경로이동**은 생략해도 됩니다.

# 과제 메인
  - 반복되는 문자(a~z)끼리의 압축  
    > aabccccaaa → **a2b1c4a3**
  - 압축된 문자열이 더 길면 그냥 문자로 리턴  
    > abcd → a1b1c1d1[X]  
    > abcd → **abcd[O])**

# ./src/comm/StringZip.java
  - **두개의 문자**(prev_char/curr_char)를 비교해서 **같으면 반복 횟수 증가** (same_count)
    > aaaaaa**aa**bcdef  
    > 이전 문자(prev_char): **a**  
    > 현재 문자(curr_char): **a**

  - **다르면** 반복된 문자와 증가된 반복횟수를 **합침**
    > 반복된 문자: **a**  
    > 반복된 횟수: **7**  
    > 결과: **a7**
  - 문자열 길이만큼 **반복**

```java
package src.comm;

public class StringZip {

    public String exec( String str ){
        // 결과
        String result = "";

        // 비교대상 문자
        char prev_char = ' ';
        char curr_char = ' ';

        // 카운트
        int same_cnt = 0;

        // 반복 처리 용
        int i = 0;
        int len = str.length();

        // 비교 대상이 없기 때문에 초기 설정
        i = 1;
        prev_char = str.charAt(i);
        
        // 마지막까지 반복 돌기 위한 조건
        while( i <= len ){

            // 문자열 길이만큼, 비교할 시작 문자 가져오기
            curr_char = ( i < len ) ? str.charAt(i) : ' ';

            // 같은 char형 카운트 세기
            same_cnt++;

            // 비교대상의 char값이 다르면 문자열 합치기 ({알파벳}{중복숫자}..)
            if( curr_char != prev_char ){
                result += (prev_char +""+ same_cnt);
                same_cnt = 0;
            }
            
            // 비교대상 값으로 설정
            prev_char = curr_char;
            i++;
        }

        // 최종 압축된 문자열 길이가 원래 문자열 길이보다 길면 원래 내용으로 반환
        return (
            result.length() > len ? str : result 
        );
    }
}
```

## 실행 결과 1 (과정포함)
> Input: **aaaaaaaaaaaaabbabkdccccddeeefg**

    a13
    a13b2
    a13b2a1
    a13b2a1b1
    a13b2a1b1k1
    a13b2a1b1k1d1
    a13b2a1b1k1d1c4
    a13b2a1b1k1d1c4d2
    a13b2a1b1k1d1c4d2e3
    a13b2a1b1k1d1c4d2e3f1
    a13b2a1b1k1d1c4d2e3f1g1

>  Output: **a13b2a1b1k1d1c4d2e3f1g1**

## 실행 결과 2  (과정포함)
> Input: **abcde**

    b2
    b2c1
    b2c1d1
    b2c1d1e1
    
> Output: **abcde**  
> 압축 길이보다 입력내용 짧아서 입력값과 같음