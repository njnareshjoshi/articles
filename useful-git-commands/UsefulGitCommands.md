# Useful Git Commands

Git is a most widely used and powerful version control system for tracking changes in computer files and coordinating work on those files among multiple people. It is primarily used for source code management in software development, but it can be used to keep track of changes in any set of files. 

Git was developed by Linus Torvalds in 2005 as an distributed open source software version control software and of course it is free to use. As a distributed revision control system it is aimed at speed, data integrity, and support for distributed, non-linear workflows.

While other version control systems e.g. CVS, SVN keeps most of their data like commit logs on central server, every git repository on every computer is a full-fledged repository with complete history and full version tracking abilities, independent of network access or a central server.



However allmost all IDEs support git out of the box and we do not require submit the git commands manually but it is always good to understand these commands. Below is a list of some git commands to work efficiently with git. 



## Git Help

The most useful command in git is `git help` which provides us all the help which we require. If we type `git help` in terminal, we will get

```shell
usage: git [--version] [--help] [-C <path>] [-c <name>=<value>]
           [--exec-path[=<path>]] [--html-path] [--man-path] [--info-path]
           [-p | --paginate | --no-pager] [--no-replace-objects] [--bare]
           [--git-dir=<path>] [--work-tree=<path>] [--namespace=<name>]
           <command> [<args>]

These are common Git commands used in various situations:

start a working area (see also: git help tutorial)
   clone      Clone a repository into a new directory
   init       Create an empty Git repository or reinitialize an existing one

work on the current change (see also: git help everyday)
   add        Add file contents to the index
   mv         Move or rename a file, a directory, or a symlink
   reset      Reset current HEAD to the specified state
   rm         Remove files from the working tree and from the index

examine the history and state (see also: git help revisions)
   bisect     Use binary search to find the commit that introduced a bug
   grep       Print lines matching a pattern
   log        Show commit logs
   show       Show various types of objects
   status     Show the working tree status

grow, mark and tweak your common history
   branch     List, create, or delete branches
   checkout   Switch branches or restore working tree files
   commit     Record changes to the repository
   diff       Show changes between commits, commit and working tree, etc
   merge      Join two or more development histories together
   rebase     Reapply commits on top of another base tip
   tag        Create, list, delete or verify a tag object signed with GPG

collaborate (see also: git help workflows)
   fetch      Download objects and refs from another repository
   pull       Fetch from and integrate with another repository or a local branch
   push       Update remote refs along with associated objects

'git help -a' and 'git help -g' list available subcommands and some concept guides.
See 'git help <command>' or 'git help <concept>' to read about a specific subcommand or concept.
```



Command `git help -a` will us complete list of git commands

```shell
Available git commands in '/usr/local/git/libexec/git-core'

  add                       clone                     fetch                     interpret-trailers        notes                     remote-testsvn            submodule
  add--interactive          column                    fetch-pack                log                       p4                        repack                    submodule--helper
  am                        commit                    filter-branch             ls-files                  pack-objects              replace                   subtree
  annotate                  commit-tree               fmt-merge-msg             ls-remote                 pack-redundant            request-pull              svn
  apply                     config                    for-each-ref              ls-tree                   pack-refs                 rerere                    symbolic-ref
  archimport                count-objects             format-patch              mailinfo                  patch-id                  reset                     tag
  archive                   credential                fsck                      mailsplit                 prune                     rev-list                  unpack-file
  bisect                    credential-cache          fsck-objects              merge                     prune-packed              rev-parse                 unpack-objects
  bisect--helper            credential-cache--daemon  gc                        merge-base                pull                      revert                    update-index
  blame                     credential-store          get-tar-commit-id         merge-file                push                      rm                        update-ref
  branch                    cvsexportcommit           grep                      merge-index               quiltimport               send-email                update-server-info
  bundle                    cvsimport                 gui                       merge-octopus             read-tree                 send-pack                 upload-archive
  cat-file                  cvsserver                 gui--askpass              merge-one-file            rebase                    sh-i18n--envsubst         upload-pack
  check-attr                daemon                    hash-object               merge-ours                rebase--helper            shell                     var
  check-ignore              describe                  help                      merge-recursive           receive-pack              shortlog                  verify-commit
  check-mailmap             diff                      http-backend              merge-resolve             reflog                    show                      verify-pack
  check-ref-format          diff-files                http-fetch                merge-subtree             remote                    show-branch               verify-tag
  checkout                  diff-index                http-push                 merge-tree                remote-ext                show-index                web--browse
  checkout-index            diff-tree                 imap-send                 mergetool                 remote-fd                 show-ref                  whatchanged
  cherry                    difftool                  index-pack                mktag                     remote-ftp                stage                     worktree
  cherry-pick               difftool--helper          init                      mktree                    remote-ftps               stash                     write-tree
  citool                    fast-export               init-db                   mv                        remote-http               status
  clean                     fast-import               instaweb                  name-rev                  remote-https              stripspace
```



And command `git help -g` will us a list git concepts

```shell
The common Git guides are:

   attributes   Defining attributes per path
   everyday     Everyday Git With 20 Commands Or So
   glossary     A Git glossary
   ignore       Specifies intentionally untracked files to ignore
   modules      Defining submodule properties
   revisions    Specifying revisions and ranges for Git
   tutorial     A tutorial introduction to Git (for version 1.5.1 or newer)
   workflows    An overview of recommended workflows with Git
```



We can use `git help <command>` or `git help <concept>` command to know more about about a specific command or concept.



## Git Configuration 

| Description                                                  | Git Command                                      |
| ------------------------------------------------------------ | ------------------------------------------------ |
| Configure the author name to be used with your commits.      | `git config --global user.name "Sam Smith"`      |
| Configure the author email address to be used with your commits | `git config --global user.email sam@example.com` |
| Will remove user credential details from the repo            | `git config --local credential.helper ""`        |
| List all currently configured remote repository urls         | `git remote -v`                                  |
| If you haven't connected your local repository to a remote server, To add a remote server to a local repository | `git remote add origin <repo_url>`               |



## Git Commit and Push

| Description                                                  | Git Command                          |
| ------------------------------------------------------------ | ------------------------------------ |
| Create a file name `README.md` with `eadme content` content  | `echo "Readme content" >> README.md` |
| List the files you've changed and those you still need to add or commit | `git status`                         |
| Add all or one file to staging                               | `git add .` OR `git add file_name`   |
| Commit changes to head with message                          | `git commit -m 'message'`            |
| Commit any files you've added with `git add`, and also commit any files you've changed since then | `git commit -a`                      |
| Send all commits from local repository to remote repository  | `git push`                           |
| Do a `git push` and sets the default remote branch for the current local branch. So any future `git pull` command will attempt to bring in commits from the `<remote-branch>` into the current local branch | `git push -u <remote-branch>`        |
| Send changes to the master branch of your remote repository  | `git push origin master`             |
| Push a specific branch to your remote repository             | `git push origin <branchname>`       |
| Push all branches to your remote repository                  | `git push --all origin`              |



## Git Checkout And Pull

| Description                                                  | Git Command                                                  |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| To create a new local repository                             | `git init`                                                   |
| Clone a repository into a new directory                      | `git clone repo_url`                                         |
| Clone a repository into a new directory and point to mentioned `branch_name` | `git clone --branch branch_name repo_url`                    |
| To create a working copy of a local repository               | `git clone /path/to/repository`                              |
| Download objects and refs from remote repository for master branch | `git fetch origin master`                                    |
| To merge a different branch into your active branch          | `git merge <branchname>`                                     |
| Fetch and merge changes on the remote server to your working directory: | `git pull`                                                   |
| View all the merge conflicts, View the conflicts against the base file, Preview changes, before merging | `git diff`, `git diff --base <filename>`, `git diff <sourcebranch> <targetbranch>` |



## Git Branch

| Description                                                  | Git Command                     |
| ------------------------------------------------------------ | ------------------------------- |
| List all the branches in your repo, and also tell you what branch you're currently in | `git branch`                    |
| Switch from one branch to another                            | `git checkout branch_name`      |
| Create a new branch and switch to it                         | `git checkout -b branch_name`   |
| Delete the feature branch from local repository              | `git branch -d <branchname>`    |
| Delete a branch on your remote repository                    | `git push origin :<branchname>` |



## Git Cleaning

| Description                                                  | Git Command                      |
| ------------------------------------------------------------ | -------------------------------- |
| Fetch the latest history (objects & refs) from the remote server for master branch | `git fetch origin master`        |
| Clean repo to intial stage                                   | `git clean -x -d -f`             |
| Reset local repo and point your local master branch to latest history fetched from remote server | `git reset --hard origin/master` |
| To bring all changes from remote repo to local repo          | `git pull origin master`         |



## Other Git commands

| Description                                                  | Git Command                  |
| ------------------------------------------------------------ | ---------------------------- |
| You can use tagging to mark a significant changeset, such as a release | `git tag 1.0.0 <commitID>`   |
| CommitId is the leading characters of the changeset ID, up to 10, but must be unique. Get the ID using | `git log`                    |
| Push all tags to remote repository                           | `git push --tags origin`     |
| If you mess up, you can replace the changes in your working tree with the last content in head:Changes already added to the index, as well as new files, will be kept | `git checkout -- <filename>` |
| Search the working directory for `foo()`                     | `git grep "foo()"`           |



## References

https://confluence.atlassian.com/bitbucketserver0414/basic-git-commands-895367449.html?utm_campaign=in-app-help&utm_medium=in-app-help&utm_source=stash