
# 구동방법

> **01. 경로이동**
> -- 
    cd ./Cracking_The_Coding_Interview/Chap9_Interview_Questions/02_Linked_Lists/2.8_LoopSearch/ThreepleK/

> **02. 컴파일**
> --
    javac -encoding UTF-8 -d ./ ./src/main/Index.java

> **03. 실행**
> --
    java src.main.Index
  - **01. 경로이동**은 컴파일과 실행하기 위한 과정이며, 이동은 한번이면 됩니다.
  - **02 .컴파일**, **03. 실행**은 이미 경로를 이동하였다면 **01. 경로이동**은 생략해도 됩니다.

# 과제 메인
  - 순환 연결리스트 일 때, 순환 되는 첫째 노드를 반환하기
    > [a, b, **c**, d, e, **c**] [2]와 [5]의 노드가 동일하고 하면  
    > [2]의 노드인 **c**가 출력

# 과제 해석 방향
  - **연결리스트를 구현**
  - 연결리스트에 **순환 연결 된 노드** 찾는 **함수 만들기**
  - 2.6과 동일 소스 베이스에 위 함수 추가

# ./src/main/Index.java
  - 값 설정 후 강제 순환 리스트 설정
    > c_list → [10, 20, 30, 99, 20, 30]  
    > c_list[5] -> c_list[3]  
    >
    > [10, 20, 30, **99**, 20, 30, **99**]   

```java
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
```

# ./src/comm/LinkedList.java
  - 기능 1: 처음/마지막 노드 가져오기
    > [a, b, c, d, e, f] → a (Head)  
    > [a, b, c, d, e, f] → f (Tail)

  - 기능 2: 원하는 위치에 노드 추가하기/ push처럼 마지막에 추가하기
    > [a, b, c, d, e, f] → **3번째** 위치에 z추가 → [a, b, c, **z**, d, e, f]  
    > [a, b, c, d, e, f] → **마지막**에 z추가 → [a, b, c, d, e, f, **z**]

  - 기능 3: 원하는 위치의 노드 가져오기
    > [a, b, c, d, e, f] → **2번째** 위치에 노드 가져오기 → **c**

  - 기능 4: 순환연결 첫번째 노드 
    > [a, **b**, c, d, e, **b**] → **b**


```java
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

```

# ./src/comm/Node.java
  - 기능 1: 연결된 노드 가져오기 (이전노드 ← 현위치 → 다음노드)
    > [a, b, c]  
    > 현재 노드: **b**  
    > 이전 노드: **a**  
    > 다음 노드: **c**

  - 기능 2: 노드 연결하기 (이전/다음 노드 연결)
  - 기능 3: 노드에 값 설정 (int)
  - 기능 4: 노드에 설정된 값 가져오기 (int)

```java
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

```

## 실행 결과
    # 순환연결 리스트 1번째 노드 찾기
    10, 20, 30, >99<, 20, 30, >>99<<
    동일 노드 확인 용 : 99