# 구동 방법1 (run: 이미 빌드된 바이너리 돌리기)
  - cd bin
  - java app.main.Index

# 구동 방법2 (build > run: 소스코드 베이스로 빌드 후 실행하기)
  - javac -encoding UTF-8 -d ./ ./app/main/Index.java
  - java app.main.Index

# 설명
  - ./app/comm/StringZip.java 소스 주석 참조

# 결과
  - 입력: aaaaaaaaaaaaabbabkdccccddeeefg
  - 출력: a13b2a1b1k1d1c4d2e3f1g1