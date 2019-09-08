//Q4. 주어진 문자열이 회문(palindrome)의 순열인지 아닌지 확인하는 함수를 구현하라
//**palindrome : 앞으로읽으나 뒤로 읽으나 같은 것
import java.util.Arrays;

public class SolJeon {
	public static void main(String[] args) {
    //짝수 길이 배열일 경우 모든 원소 2개씩
    //홀수 길이 배열일 경우 모든 원소 2개씩, 1개원소 1개
    int[] check = new int[26];

    String s = "";
    for(int i=0;i<args.length;i++)s+=args[i];

    s = s.toLowerCase();//대소문자 구분 안해도 됨.
    s = s.trim();
    for(int i=0;i<s.length();i++){
      if(s.charAt(i)==' ')continue;
      else {
        char c = s.charAt(i);
        int k = c-'a';
        check[k]++;
      }
    }
    int count2=0,count1=0; //count 1s and 2s
    for(int i=0;i<check.length;i++){
      if(check[i]%2==0)count2++;
      else if(check[i]%2==1)count1++;
    }
    System.out.println(s.length());
    if(s.length()==0){
      System.out.println("false");
    }
    else if(s.length()%2==0){
      if(count1==0){
        System.out.println("true");
      }
      else{
        System.out.println("false");
      }
    }
    else
    {
      if(count1==1){
        System.out.println("true");
      }
      else{
        System.out.println("false");
      }
    }
    return;
	}

}
