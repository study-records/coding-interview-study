package src.comm;
import src.comm.Node;

//* Linked list
public class LinkedList {

    // Node 시작/끝
    private Node head;
    private Node tail;

    // 리스트 길이
    private int size;

    //* 생성자
    public LinkedList(){
        head = null;
        size = 0;
    }

    //* 제일 앞/뒤 부분 노드 가져오기
    public Node getHead(){
        return this.head;
    }
    public Node getTail(){
        return this.tail;
    }

    //* 노드 추가하기 (원하는 위치)
    public void add( int idx, Node n ){
        
        // 추가할 위치가 0 ~ this.size 범위를 넘어 갈 경우 에러처리
        if( idx < 0 || idx > this.size ){
            throw new IndexOutOfBoundsException();
        }

        Node target_node = null;

        // 첫번째 노드일 경우
        if( idx == 0 ){

            // 설정된 헤드가 없을 경우 아예 초기 설정
            if( this.head == null ){
                this.head = n;
                this.tail = n;
            }
            // 설정된 헤드가 있을 경우 0번재 index에 있는걸 1위치로 밀어냄
            else {
                // 리스트 개수가 1개일 경우 시작 헤드를 뒤로
                if( this.size == 1 ){
                    this.tail = this.head;
                }

                // 추가될 노드 뒤에 헤드 붙임
                n.setNext( this.head );
                n.getNext().setPrev(n);
            }
        }

        // 그 외 노드위치에 추가할 경우
        else {
            // 추가될 위치의 node 가져오기
            target_node = this.get( idx-1 );

            // 추가 될 노드의 앞/뒤로 node 연결
            n.setPrev( target_node );
            n.setNext( target_node.getNext() );

            // 앞부분의 다음 노드를 추가될 node로
            n.getPrev().setNext( n );

            // 뒷부분의 노드의 이전 노드를 추가될 node로 (단 node일 경우)
            if( n.getNext() != null ){
                n.getNext().setPrev( n );
            }

            // 마지막 위치일 경우 tail 설정
            if( idx == this.size ){
                this.tail = n;
            }
        }

        // 추가된 노드 수 증가
        this.size++;
    }

    //* 노드 추가하기 (뒤에다가)
    public void append( Node n ){
        add( this.size, n );
    }

    //* 노드 가져오기
    public Node get( int idx ){

        // 초기 헤더나 범위를 벗어난 idx일 경우 에러
        if( this.head == null && ( idx < 0 || idx > this.size) ){
            throw new IndexOutOfBoundsException();
        }

        // 초기 Node 설정
        Node target_node;

        // 가져올 Node까지 index 설정 용
        int i;
        int target_idx = idx;

        target_node = this.head;
        i = 0;

        while( i < target_idx ){
            target_node = target_node.getNext();
            i++;
        }

        // node 가져오기
        return target_node;
    }

    //* 노드 전부 출력 하기
    public void printNodes(){
        Node n = this.head;
        
        int len = this.size;
        int i = 0;

        while( i < len ){
            System.out.print(
                n.getData() +( i < len-1 ? ", " : "\n" )
            );
            n = n.getNext();
            i++;
        }
    }

    //* 회문 확인
    public boolean is_palindrme(){
        boolean result = true;

        // 왼쪽/오른쪽 끝 부분 각각 설정
        Node left = this.head;
        Node right = this.tail;

        // 연결된 노드 개수의 절반 만큼 설정
        int len = (int)Math.floor(this.size * 0.5);
        int i = 0;

        // 연결된 노드의 절반만 반복
        while( i < len ){

            // 왼쪽 노드와 오른쪽 노드의 값이 다르면 회문 X
            if( left.getData() != right.getData() ){
                result = false;
            }

            // 왼쪽은 다음노드 / 오른쪽은 이전노드 가져오기
            left = left.getNext();
            right = right.getPrev();

            i++;
        }

        // 값이 다른적이 없기에 회문 O
        return result;
    }
}
