package src.comm;

//* Linked list에서 사용될 노드
public class Node {
    private Node prev = null;
    private Node next = null;
    private int data;

    //* 생성시에도 데이터 설정
    public Node( int d ){
        this.data = d;
    }

    //* 이전/다음 노드 가져오기
    public Node getPrev(){
        return prev;
    }
    public Node getNext(){
        return next;
    }

    //* 이전/다음 노드 설정하기
    public void setPrev( Node n ){
        this.prev = n;
    }
    public void setNext( Node n ){
        this.next = n;
    }

    //* 데이터 가져오기
    public int getData(){
        return this.data;
    }

    //* 데이터 설정하기
    public void setData( int data ){
        this.data = data;
    }
}
