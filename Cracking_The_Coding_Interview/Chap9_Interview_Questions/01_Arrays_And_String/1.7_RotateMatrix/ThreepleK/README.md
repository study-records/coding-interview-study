
# 구동방법

> **01. 경로이동**
> -- 
    cd ./Cracking_The_Coding_Interview/Chap9_Interview_Questions/01_Arrays_And_String/1.7_RotateMatrix/ThreepleK/
> **02. 컴파일**
> --
    javac -encoding UTF-8 -d ./ ./src/main/Index.java
> **03. 실행**
> --
    java src.main.Index
  - **01. 경로이동**은 컴파일과 실행하기 위한 과정이며, 이동은 한번이면 됩니다.
  - **02 .컴파일**, **03. 실행**은 이미 경로를 이동하였다면 **01. 경로이동**은 생략해도 됩니다.

# 과제 메인
  - NxN 이미지 행렬 (픽셀은 4바이트로 표현)
  - 추가 행렬을 사용하지 않고 이미지를 90도 회전 시키기

# 과제 해석 방향
  - **실제 이미지**가 가지는 픽셀은 **RGB** or **RGBA** 이지만 **4바이트**로 표현하라고 했으니 **RGBA**로 택함  
    *(1바이트: 0~255 / 0x00 ~ 0xff)*

  - **그래픽**의 **실제 이미지**는 2차배열(X) → **1차배열(O)**  
    *( 과제는 **NxN행렬**을 흉내내는 **1차배열**을 택함 )*

  - 보통 그래픽에선 **이미지를 훼손하지 않고** 연산으로 **캔버스에** 출력  
    *( 과제는 **데이터 변형없이** 콘솔에 **출력** )*

  - 콘솔에서 실제 출력하는 픽셀의 정보는 **RGBA**에서 **Alpha**만 출력

# ./src/main/Index.java
  - 1차원 배열에 이미지 정보는 아래와 같음
    > Alpha만 출력하기 때문에 RGB부분은 통일 함  
    > FFFFFF0A, FFFFFF0B, FFFFFF0C, FFFFFF0D,  
    > FFFFFF14, FFFFFF15, FFFFFF16, FFFFFF17,    
    > FFFFFF1E, FFFFFF1F, FFFFFF20, FFFFFF21     
    > 
    > Alpha만 10진수로 표기하면  
    > 10, 11, 12, 13,  
    > 20, 21, 22, 23,  
    > 30, 31, 32, 33

  - 아래 코드는 **이미지 넓이를 4px설정** 하기위함이며, 넓이를 변경 후 회전 가능
```java
ImageRotate i_rotate = new ImageRotate(image, 4);
```

```java
package src.main;
import src.comm.*;

public class Index {

    public static void main(String[] args) {
        //* 이미지 90도 회전
        System.out.println( "# 이미지 회전 (4x3)" );

        // 4x3 byte 이미지 저장
        byte[] image = {
            (byte)0xff,(byte)0xff,(byte)0xff,(byte)0x0a, (byte)0xff,(byte)0xff,(byte)0xff,(byte)0x0b, (byte)0xff,(byte)0xff,(byte)0xff,(byte)0x0c, (byte)0xff,(byte)0xff,(byte)0xff,(byte)0x0d,
            (byte)0xff,(byte)0xff,(byte)0xff,(byte)0x14, (byte)0xff,(byte)0xff,(byte)0xff,(byte)0x15, (byte)0xff,(byte)0xff,(byte)0xff,(byte)0x16, (byte)0xff,(byte)0xff,(byte)0xff,(byte)0x17,
            (byte)0xff,(byte)0xff,(byte)0xff,(byte)0x1e, (byte)0xff,(byte)0xff,(byte)0xff,(byte)0x1f, (byte)0xff,(byte)0xff,(byte)0xff,(byte)0x20, (byte)0xff,(byte)0xff,(byte)0xff,(byte)0x21
        };
        // 1차 배열이라 강제 넓이 설정
        ImageRotate i_rotate = new ImageRotate(image, 4);

        // 이미지 회전 출력 (N-북/E-동/S-남/W-서)
        System.out.println( "[ 정방향 ]" );
        i_rotate.print( 'N' );
        System.out.println( "[ 90도 ]" );
        i_rotate.print( 'E' );
        System.out.println( "[ -90도 ]" );
        i_rotate.print( 'W' );
    }
}
```
# ./src/comm/ImageRotate.java
  - Byte단위 **배열 이미지와 넓이**를 받아 **회전**
    > N: **0도**  
    > E: **90도**  
    > S: **180도**  
    > W: **270도**  
    > 
    > **동/서/남/북** 방향으로 **회전**,   
    > 알파벳 앞글자만 따와서 회전방향 정함

```java
package src.comm;

public class ImageRotate {

    //* 바이트 단위 이미지
    byte[] image;

    //* 이미지 넓이
    int image_width;

    //* 1px당 담길 byte 수 (RGBA)
    byte jump = 4;

    //* 생성자 이미지 초기 값 설정
    public ImageRotate( byte[] image, int width ){
        this.image = image;
        this.image_width = width;
    }

    //* 이미지 90회전 출력 (rType: N-북/E-동/S-남/W-서)
    public void print( char rType ){
        int imageLen = this.image.length;

        int xMax = this.image_width * this.jump;
        int yMax = imageLen / xMax;
        int wMax = 0;

        int x = 0;
        int y = 0;
        int i = 0;

        // 시계방향 회전
        if( rType == 'E' ){

            while( x < xMax ){
                y = yMax-1;
                
                while( y >= 0 ){
                    i = (y*xMax) + x;
                    System.out.print( image[i+3]+" " );
                    y--;
                }

                System.out.print( "\n" );

                x+=jump;
            }
        }
        // 반시계방향 회전
        else if( rType == 'W'){

            x = xMax - jump;
            while( x >= 0 ){
                y = 0;
                
                while( y < yMax ){
                    i = (y*xMax) + x;
                    System.out.print( image[i+3]+" " );
                    y++;
                }
    
                System.out.print( "\n" );
    
                x-=jump;
            }
        }
        // 정 방향
        else if ( rType == 'N' ){

            wMax = xMax - jump;
            while( i < imageLen ){
                System.out.print( image[i+3]+" " );
                
                if( i % xMax == wMax ){
                    System.out.print( "\n" );
                }

                i += jump;
            }
        }
        // 180도
        else if ( rType == 'S' ){

            i = imageLen - jump;
            while( i >= 0 ){
                System.out.print( image[i+3]+" " );
                
                if( i % xMax == 0 ){
                    System.out.print( "\n" );
                }

                i -= jump;
            }
        }
        // 회전방향이 없을 경우
        else {
            System.out.println("Unknown rotate type.");
        }
    }
}
```

## 실행 결과
    # 이미지 회전 (4x3)
    [ 정방향 ]
    10 11 12 13
    20 21 22 23
    30 31 32 33
    [ 90도 ]
    30 20 10
    31 21 11
    32 22 12
    33 23 13
    [ -90도 ]
    13 23 33
    12 22 32
    11 21 31
    10 20 30