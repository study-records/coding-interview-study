
Successor
====

### 문제 : 현재 노드가 주어지고 in-order search한다고 가정했을 때 다음 노드를 구하라
* 부모노드와의 링크가 주어진다

### Pseudo Code
- 기본 가정 : 현재 노드의 왼쪽 자식들은 모두 순회하였을 것이다
- in-order search 순서 : left -> node -> right
- 만약 오른쪽 자식노드가 존재한다면 오른쪽 어딘가 일 것이다.
- 존재하지 않는다면 부모노드이다.

```java
node successor(Node node){
  //오른쪽 자식 없을 경우
 if(node.right == null) return node.parent;
 else{
   while(1){
     if(node.left==null && node.right==null)
       return node;
     else if(node.left!=null)node = node.left;
     else node=node.right;
   }
 }  
}
```
