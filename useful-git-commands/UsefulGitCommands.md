# Useful Git Commands

Git is a most widely used and powerful version control system for tracking changes in computer files and coordinating work on those files among multiple people. It is primarily used for source code management in software development, but it can be used to keep track of changes in any set of files. 

Git was developed by Linus Torvalds in 2005 as an distributed open source software version control software and of course it is free to use. As a distributed revision control system it is aimed at speed, data integrity, and support for distributed, non-linear workflows.

While other version control systems e.g. CVS, SVN keeps most of their data like commit logs on central server, every git repository on every computer is a full-fledged repository with complete history and full version tracking abilities, independent of network access or a central server.



Below is a list of some Git commands to work efficiently with Git. 



## Git Configuration 

|                                                              |                                                  |
| ------------------------------------------------------------ | ------------------------------------------------ |
| Configure the author name to be used with your commits.      | `git config --global user.name "Sam Smith"`      |
| Configure the author email address to be used with your commits. | `git config --global user.email sam@example.com` |
| Will remove user credential details from the repo            | `git config --local credential.helper ""`        |
| List all currently configured remote repository urls         | `git remote -v`                                  |
| If you haven't connected your local repository to a remote server, To add a remote server to a local repository | `git remote add origin <repo_url>`               |



## Git Commit and Push

|                                                              |                                      |
| ------------------------------------------------------------ | ------------------------------------ |
| List the files you've changed and those you still need to add or commit | `git status`                         |
| Add more or one file to staging                              | `git add .` OR `git add file_name`   |
| Commit changes to head with message                          | `git commit -m 'message'`            |
|                                                              | `git push -u origin master`          |
|                                                              | `git push`                           |
|                                                              | `echo "Readme content" >> README.md` |
| Commit any files you've added with `git add`, and also commit any files you've changed since then: | `git commit -a`                      |
| Send changes to the master branch of your remote repository: | `git push origin master`             |
| Push a specific branch to your remote repository             | `git push origin <branchname>`       |
| Push all branches to your remote repository                  | `git push --all origin`              |



## Git Checkout And Pull

|                                                              |                                                              |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| To create a new local repository                             | `git init`                                                   |
|                                                              | `git remote add origin repo_url`                             |
|                                                              | `git fetch origin master`                                    |
|                                                              | `git clone repo_url`                                         |
|                                                              | `git clone --branch branch_name --recursive repo_url`        |
| To create a working copy of a local repository               | `git clone /path/to/repository`                              |
| Fetch and merge changes on the remote server to your working directory: | `git pull`                                                   |
| To merge a different branch into your active branch:         | `git merge <branchname>`                                     |
| View all the merge conflicts, View the conflicts against the base file, Preview changes, before merging: | `git diff`, `git diff --base <filename>`, `git diff <sourcebranch> <targetbranch>` |



## Git Branch

|                                                              |                                 |
| ------------------------------------------------------------ | ------------------------------- |
| List all the branches in your repo, and also tell you what branch you're currently in | `git branch`                    |
| Switch from one branch to another                            | `git checkout branch_name`      |
| Create a new branch and switch to it                         | `git checkout -b branch_name`   |
| Delete the feature branch from local repository              | `git branch -d <branchname>`    |
| Delete a branch on your remote repository:                   | `git push origin :<branchname>` |



## Git Cleaning

|                                                     |                                  |
| --------------------------------------------------- | -------------------------------- |
|                                                     | `git fetch origin master`        |
| To clean repo to intial stage                       | `git clean -x -d -f`             |
| To reset local repo                                 | `git reset --hard origin/master` |
| To bring all changes from remote repo to local repo | `git pull origin master`         |



## Other Git commands

|                                                              |                                                    |
| ------------------------------------------------------------ | -------------------------------------------------- |
| You can use tagging to mark a significant changeset, such as a release: | `git tag 1.0.0 <commitID>`                         |
| CommitId is the leading characters of the changeset ID, up to 10, but must be unique. Get the ID using: | `git log`                                          |
| Push all tags to remote repository:                          | `git push --tags origin`                           |
| If you mess up, you can replace the changes in your working tree with the last content in head:Changes already added to the index, as well as new files, will be kept. | `git checkout -- <filename>`                       |
| Instead, to drop all your local changes and commits, fetch the latest history from the server and point your local master branch at it, do this: | `git fetch origin  git reset --hard origin/master` |
| Search the working directory for `foo()`:                    | `git grep "foo()"`                                 |



## References

https://confluence.atlassian.com/bitbucketserver0414/basic-git-commands-895367449.html?utm_campaign=in-app-help&utm_medium=in-app-help&utm_source=stash