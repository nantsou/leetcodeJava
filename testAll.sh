#!/bin/bash

echo START TEH TESTS

javac -d $BASE_BIN $BASE_SRC/objs/*.java
javac -d $BASE_BIN $BASE_SRC/utils/*.java

export MAIN_DIR=./src/main
cnt=0
for f in $MAIN_DIR/*.java
do
  ff=${f##*/}
  ff=${ff%.*}
  if [ "$ff" = "Main" ]; then
    continue
  fi
  echo Run Problem $ff
  cp -f $BASE_SRC/main/$ff.java $BASE_SRC/main/Main.java
  cp -f $BASE_SRC/sols/$ff.java $BASE_SRC/sols/Solution.java
  javac -d $BASE_BIN/ $BASE_SRC/sols/Solution.java
  javac -d $BASE_BIN/ $BASE_SRC/main/Main.java
  java main.Main $CURRENT_DIR/input/$ff.txt
  echo done
  echo
  let cnt=cnt+1
done
echo $cnt problems were run.