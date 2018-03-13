#!/bin/bash

# compile and run

PATHSEP=":"
if [[ $OS == "Windows_NT" ]]
then
    PATHSEP=";"
fi

javac -cp .${PATHSEP}lib/java-json.jar src/Main.java
if [ $# -eq 1 ];
then
    java -cp .${PATHSEP}lib/java-json.jar src/Main $1
elif [ $# == 0 ];
then
    java -cp .${PATHSEP}lib/java-json.jar src/Main
fi