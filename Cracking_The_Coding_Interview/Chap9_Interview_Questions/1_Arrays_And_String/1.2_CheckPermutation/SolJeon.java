//Q2. 문자열 두개가 주어졌을 때 이 둘이 서로 순열 관계에 있는지 확인하는 메서드 작성
import java.util.Arrays;

public class SolJeon {
  public String sort(String s){
    char[] chars = s.toCharArray();
    Arrays.sort(chars);
    return new String(chars);
  }
  boolean check(String s1, String s2){
    return sort(s1).equals(sort(s2));
  }
	public static void main(String[] args) {
    //Assume string is all ASCII code
    String s1 = args[0];
    String s2 = args[1];
    Solution k = new Solution(); // main is static
    System.out.println(k.check(s1,s2));
    return;
	}
}
