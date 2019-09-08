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
                System.out.println( result );
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