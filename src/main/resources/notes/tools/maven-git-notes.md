# Maven Commands

### Change Version

`mvn versions:set -DnewVersion=01234-SNAPSHOT`

### Clean Install - Skipping Test
`mvn clean install -DskipTests -Dmaven.javadoc.skip=true -Dfindbugs.skip=true -Dmaven.clover.skip=true -DskipITs`

### Deploy Docker Image
`mvn clean package -Dfindbugs.skip=true  docker:stop docker:build docker:start  docker:logs -Ddocker.follow -Ddocker.logDate=DEFAULT -Dmaven.test.skip=true`

# Git Commands

## Show All the Git Configuration
`git config --list --show-origin`


## The local config file is in the project directory: 
`.git/config`

## The global config file in in your home directory: 
`~/.gitconfig`

## Change User Name
`git config --global user.name "Amar Kumar"`

## Change User Email
`git config --global user.email amar@gmail.com`

## Change the Editor
`git config --global core.editor atom`

## Remote Connection
```text
git init
git add README.md
git commit -m "first commit"
git remote add origin https://github.com/amarkum/repss.git
git push -u origin master
```

## SBT `.gitignore`
```text
# sbt
# (may want to keep parts of 'project')
bin/
project/
target/
build/

# eclipse
build
.classpath
.project
.settings
.worksheet

# intellij idea
*.log
*.iml
*.ipr
*.iws
.idea

# mac
.DS_Store

# other?
.history
.scala_dependencies
.cache
.cache-main

#general
*.class
```
