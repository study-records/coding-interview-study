// 행렬 90도 회전
//  1 0 0      0 0 1
//  0 0 1 -->  0 0 0
//  0 0 1      1 1 0
import java.util.Scanner;
public class SolJeon{
	public static void main(String[] args) {
    int [][]matrix = new int [10][10];
    Scanner sc = new Scanner(System.in);

    int n;
    n = sc.nextInt();
    for(int i=0;i<n;i++){
      for(int j=0;j<n;j++){
        matrix[i][j] = sc.nextInt();
      }
    }
    int [][] rotate = new int[10][10];
    for(int i=0;i<n;i++){
      for(int j=0;j<n;j++){
        rotate[i][j] = matrix[n-j-1][i];
      }
    }
    System.out.println("");
    for(int i=0;i<n;i++){
      for(int j=0;j<n;j++){
        System.out.print(rotate[i][j]+" ");
      }
      System.out.println("");
    }
    return;
  }
}
//O(n*n)
//memory : n*n
