package src.main;
import src.comm.*;

public class Index {

    public static void main(String[] args) {
        //* 문자열 압축
        System.out.println( "# 문자열 압축" );

        StringZip szip = new StringZip();
        String str = "aaaaaaaaaaaaabbabkdccccddeeefg";
        
        System.out.println( "  - 압축 전: "+str );
        System.out.println( "  - 압축 후: "+ szip.exec(str) );
    }
}