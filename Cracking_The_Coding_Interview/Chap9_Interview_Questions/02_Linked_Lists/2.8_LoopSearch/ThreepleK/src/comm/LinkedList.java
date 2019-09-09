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
    
    //* 다시 반복 되는 첫번째 Node 찾기
    public Node getCircular_firstNode(){

        // 시작/다음 노드 설정
        Node curr_node = this.head;
        Node target_node = curr_node.getNext();

        // 반복 용
        int i = 0;
        int j = 0;

        // 리스트 개수만큼 반복
        while( i < this.size ){

            // 체크한 노드 외 나머지 반복
            j = 0;
            while( j < (this.size-i) ){

                // 비교 대상 노드와 현재 노드가 같다면 리턴
                if( target_node.getNext() == curr_node ){
                    return curr_node;
                }

                // 비교 대상 다음 노드 가져오기
                target_node = target_node.getNext();
                j++;
            }

            // 다음노드 설정
            curr_node = curr_node.getNext();
            target_node = curr_node.getNext();
            i++;
        }

        // 같은 노드가 없을경우
        return null;
    }
}
