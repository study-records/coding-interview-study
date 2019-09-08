//Q3. 문자열에 들어있는 모든 공백을 %20dmfh qkRnsms aptjem wkrtjd
import java.util.Arrays;

public class SolJeon {
	public static void main(String[] args) {
    //Assume string is all ASCII code
    String s = "Mr John Smith";
    char[] chars = s.toCharArray();
    StringBuilder result = new StringBuilder();
    for(int i=0;i<chars.length;i++){
      if (chars[i]==' ') {result.append("%20");}
      else result.append(chars[i]);
    }
    System.out.println(result.toString());
    return;
	}
}
