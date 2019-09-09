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