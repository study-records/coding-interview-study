//Q1. 문자열이 주어졌을 때 이 문자열에 같은 문자가 중복되어 등장하는지 확인하는 알고리즘

public class SolJeon{
	public static void main(String[] args) {
    //Assume string is all ASCII code
    String s = args[0];
    boolean[] check = new boolean[256]; // 문자열 중복 확인 변수
    for(int i=0;i<s.length();i++){
       char c = s.charAt(i);
       int t = (int)c;
       //System.out.println(t);
      if(check[t]==true) {
        System.out.println(false);
        return;
      }
      check[t]=true;
    }
    System.out.println(true);
    return;
	}
}
