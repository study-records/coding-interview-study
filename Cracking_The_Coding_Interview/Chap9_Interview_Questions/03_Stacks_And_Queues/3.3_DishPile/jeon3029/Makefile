# Made by jeon3029
# Date : 2019 09 16

CC = javac

SUBDIR = src/main src/structure
CLASSES = Solution.class Stack.class StackArray.class

all : compile

compile :
    @for dir in $(SUBDIR); do make -C $$dir || exit $? done

clean :
    @for dir in &(SUBDIR); do make -C $$dir clean; done
    rm -rf *.class


