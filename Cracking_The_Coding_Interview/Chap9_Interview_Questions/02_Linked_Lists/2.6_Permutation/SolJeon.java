//Q6. 연결리스트가 회문인지 검사하는 함수를 작성하라.
//EX : 0>1>2>1>0 등...
//핵심 기법 : 연결 리스트 뒤집기
public class SolJeon{
	public static void main(String[] args) {
    //Assume string is all ASCII code
    String s = args[0];
    LinkedListJeon N = new LinkedListJeon();
    for(int i=0;i<s.length();i++){
      N.addLast(s.charAt(i));
    }
    LinkedListJeon Reversed = N.reverse();
    boolean t;
    if(N.isEqual(Reversed)) t= true;
    else t= false;
    System.out.println(t);
    return;
	}
}
