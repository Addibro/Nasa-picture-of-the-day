#!/bin/bash

# compile and run
javac -cp .:lib/java-json.jar Main.java
if [ $# -eq 1 ];
then
    java -cp .:lib/java-json.jar Main $1
elif [ $# == 0 ];
then
    java -cp .:lib/java-json.jar Main
fi