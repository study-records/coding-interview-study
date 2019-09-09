
# 구동방법

> **01. 경로이동**
> -- 
    cd ./Cracking_The_Coding_Interview/Chap9_Interview_Questions/02_Linked_Lists/2.6_Permutation/ThreepleK/

> **02. 컴파일**
> --
    javac -encoding UTF-8 -d ./ ./src/main/Index.java

> **03. 실행**
> --
    java src.main.Index
  - **01. 경로이동**은 컴파일과 실행하기 위한 과정이며, 이동은 한번이면 됩니다.
  - **02 .컴파일**, **03. 실행**은 이미 경로를 이동하였다면 **01. 경로이동**은 생략해도 됩니다.

# 과제 메인
  - 연결리스트가 회문인지 검사 하는 함수 만들기 
    > [0, 1, 2, 7, 8] → **회문 X**  
    > [0, 1, 2, 1, 0] → **회문 O** 

# 과제 해석 방향
  - **연결리스트를 구현**
  - 연결리스트에 **회문 검사**하는 **함수 만들기**
  - **회문 검사용**으로는 단방향 보단 **양방향!**  
    *( **양쪽에서 검사**하면 **반복을 절반 만** 할 수 있다 판단 )*

# ./src/main/Index.java
  - 회문 체크 용 *연결리스트 2개 설정*
    > list_1 → [10, 20, 30, 99, 30, 20, 10]  
    > list_2 → [10, 20, 30, 40, 90, 60, 70]


```java
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

  - 기능 4: 추가된 노드 출력하기
    > [a, b, c, d, e, f] → **a, b, c, d, e, f**

  - 기능 5: 회문 확인하기
    > [a, b, c, d, e, f] → **false**  
    > [a, b, c, c, b, a] → **true**  
    > 
    > 

  - 노드삭제 기능은 추가하지 않음

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
    # 연결리스트 회문
    -----------------------------------
    1번째: 10, 20, 30, 99, 30, 20, 10
    회문 : true
    -----------------------------------
    2번째: 10, 20, 30, 40, 90, 60, 70
    회문 : false