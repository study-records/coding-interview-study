

DishPile
====

### 컴파일 방법 1)

0. current diretory : ~/jeon3029/.
1. javac src/*/*.java
2. java main/Solution stucture/Stack structure/StackArray


### 알고리즘 설명

```java
//먼저 간단한 Stack interface 를 구축한다.
public interface Stack<T>{
    void push(T number);
    T pop();
    T peek();
    boolean isEmpty();
    boolean isFull();
}
//StackArray class로 만들어진 Stack 내부 함수와 maxSize를 넘어갔을 때
ArrayList형태로 저장될 수 있게끔 구성한다.
public class StackArray <T> implements Stack<T>{
    ArrayList<Object[]> stacks = new ArrayList<>();
}

```
- 핵심 기법
1. push 할 때 maxSize인 경우
```java
//새로운 스택 생성
array = newStack(); //newStack안에 기존 array는 저장해둠
array[++top] = element;
```
2. pop할 때 바닥인경우
```java
if(!this.isEmpty()){
    if(i>0 && top==0){
        T ret = (T)array[top]; //기존 바닥 저장
        i--;
        array = stacks.get(i);//stackarray 에서 저장된 array할당
        top = maxSize-1;
        return ret;
    }
    return (T)array[top--];
}
```
