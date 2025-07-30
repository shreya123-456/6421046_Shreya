#!/bin/bash

>>git --version 
git version 2.41.0.windows.1

git config --global user.name "Shreya"
git config --global user.email "Shreya6@gmail.com"
git config --global core.editor "notepad++"

mkdir GitDemo
cd GitDemo
git init

echo "Welcome to Git Hands-On Lab!" > welcome.txt

git add welcome.txt

git commit -m "Initial commit with welcome.txt"

