git config --global user.name "Shreya"
git config --global user.email "Shreya6@gmail.com"

git checkout master
git status
echo "<message>Hello from branch</message>" > hello.xml
git add hello.xml
git commit -m "Added hello.xml in GitWork"
git checkout master
echo "<message>Hello from master</message>" > hello.xml
git add hello.xml
git commit -m "Added hello.xml in master"
git log --oneline --graph --decorate --all
git diff GitWork

git merge GitWork

cat hello.xml
