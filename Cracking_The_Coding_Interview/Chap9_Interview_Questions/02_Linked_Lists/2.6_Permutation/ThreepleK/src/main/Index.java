package src.main;
import src.comm.*;

public class Index {

    public static void main(String[] args) {

        //* Linked list 구현
        System.out.println( "# 연결리스트 회문" );
        LinkedList list_1 = new LinkedList();
        LinkedList list_2 = new LinkedList();

        list_1.append(new Node(10));
        list_1.append(new Node(20));
        list_1.append(new Node(30));
        list_1.append(new Node(99));
        list_1.append(new Node(30));
        list_1.append(new Node(20));
        list_1.append(new Node(10));

        list_2.append(new Node(10));
        list_2.append(new Node(20));
        list_2.append(new Node(30));
        list_2.append(new Node(40));
        list_2.append(new Node(90));
        list_2.append(new Node(60));
        list_2.append(new Node(70));

        System.out.println("-----------------------------------");
        System.out.print("1번째: ");
        list_1.printNodes();
        System.out.println( "회문 : "+ (list_1.is_palindrme() ? "true" : "false") );

        System.out.println("-----------------------------------");
        System.out.print("2번째: ");
        list_2.printNodes();
        System.out.println( "회문 : "+ (list_2.is_palindrme() ? "true" : "false") );

    }
}