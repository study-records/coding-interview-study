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