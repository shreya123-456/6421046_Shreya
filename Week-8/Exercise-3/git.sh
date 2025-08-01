git config --global user.name "Shreya"
git config --global user.email "Shreya6@gmail.com"

# Check current branch
git branch

git branch GitNewBranch

git branch

git checkout GitNewBranch

echo "This is a file in GitNewBranch" > branchfile.txt
git add branchfile.txt
git commit -m "Added branchfile.txt in GitNewBranch"

git status

git checkout master

git diff GitNewBranch

git merge GitNewBranch

git log --oneline --graph --decorate

git branch -d GitNewBranch

git status
