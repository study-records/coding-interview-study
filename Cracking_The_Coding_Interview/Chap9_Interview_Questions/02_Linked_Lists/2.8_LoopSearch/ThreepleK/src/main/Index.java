package src.main;
import src.comm.*;

public class Index {

    public static void main(String[] args) {

        //* 순환연결 리스트 찾기
        System.out.println( "# 순환연결 리스트 1번째 노드 찾기" );
        LinkedList c_list = new LinkedList();
        c_list.append(new Node(10));
        c_list.append(new Node(20));
        c_list.append(new Node(30));
        c_list.append(new Node(99));
        c_list.append(new Node(20));
        c_list.append(new Node(30));

        // 강제 순환 연결 리스트 만들기 
        c_list.get(5).setNext( c_list.get(3) );

        // 강제
        System.out.println(
            c_list.get(0).getData()+", "+
            c_list.get(1).getData()+", "+
            c_list.get(2).getData()+", >"+
            c_list.get(3).getData()+"<, "+
            c_list.get(4).getData()+", "+
            c_list.get(5).getData()+", >>"+
            c_list.get(6).getData()+"<<"
        );

        // 순환 연결 리스트 첫째 노드 가져오기
        Node n = c_list.getCircular_firstNode();
        System.out.println( "동일 노드 확인 용 : "+ (n != null ? n.getData() : "null") );

    }
}