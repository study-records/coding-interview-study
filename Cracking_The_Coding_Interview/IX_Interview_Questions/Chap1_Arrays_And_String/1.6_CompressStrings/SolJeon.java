// 반복되는 문자의 개수를 세는 문자열 압축 알고리즘 작성
//ex) aabbccdde => a2b2c2d2e1
public class SolJeon{
	public static void main(String[] args) {
		String s="";
		for(int i=0;i<args.length;i++)s+=args[i];
    String compressed = "";
    int count=0;
    for(int i=0;i<s.length();i++){
      count++; //개수 카운트
      if(i+1 == s.length()){//마지막 문자
        compressed += "" +s.charAt(i)+count;
      }
      else if(s.charAt(i)!=s.charAt(i+1)){ //다음문자와 다를경우 compressed
        compressed += "" + s.charAt(i)+count;
        count=0;
      }
    }
    System.out.println(compressed);
    return;
  }
}
//O(n)
//StringBuilder 사용하면 속도 향상 가능
