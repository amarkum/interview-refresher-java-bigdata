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

## Change User Name
`git config --global user.name "Amar Kumar"`

## Change User Email
`git config --global user.email amar@gmail.com`

## Change the Editor
`git config --global core.editor atom`


# UNIX Commands
Too lookup space in particular directory by size
`sudo du -hs /tmp /home /home/amarkum/* | sort -rh | head -10`