#  회문 판별(연결 리스트)
- 두가지 방법으로 구현 가능하다
1. 뒤집어서 같은지 판별
2. stack 에 중간까지 쌓고, 중간부터 빼면서 마지막까지 stack에서 pop하면서 같은지 확인


## 1. Algorithm
- Soltion 해당 알고리즘으로 작성됨
>```java
>//LinkedList 구현
>//reverse / isEqual 구현
>boolean isPalindrome(LinkedList p){
>  //p : 123454321
>   LinkedList reversed = p.reverse();
>   if(p.isEqual(reversed)) return true;
>   else return false;
> }
>```

## 2. Algorithm
- slow Runner 와 fast Runner활용하면 중간지점 찾을 수 있음
> ```java
> boolean isPalindrome(LinkedList p){
>   Node fast = head;
>   Node slow = head;
>   Stack s = new Stack();
>   while(fast!=null && fast.next!=null){
>     s.push(slow.data);
>     slow=slow.next;
>     fast = fast.next.next;
>   }
>   if(fast!=null){//홀수개인경우
>     slow = slow.next;
>   }
>   while(slow!=null){
>    Object t = s.top();s.pop();
>    if(slow.data!=t)return false;
>      slow=slow.next;
>    }
>    return true;
>  }
>     
