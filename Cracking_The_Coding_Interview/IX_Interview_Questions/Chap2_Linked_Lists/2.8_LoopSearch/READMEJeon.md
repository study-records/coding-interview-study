# 순환지점 찾기

- FastRunner, SlowRunner 사용

- Assume
   FastRunner : 2 steps at 1 time.
   SlowRunner : 1 step at 1 time.

- First time when they meet
  (N = slow runner distance, K = LoopStarting point
   D = distance from LoopStarting point)
  --> 2N =K + D + LoopSize * a
  --> N = K + D + LoopSize * b
  -->2K + 2D + LoopSize*2b = K + D + LoopSize*a
  -->K + D = LoopSize*(a-2b)

이말은 즉슨 K+D 가 LoopSize의 배수란 말이고, 여기서 K만큼 더해주게되면

K+LoopSize(a-2b) 가 된다.  --> StartingPoint!!
따라서 처음 만난 이후에 한번 더만날때까지 같은속도로 반복해주면 된다.
