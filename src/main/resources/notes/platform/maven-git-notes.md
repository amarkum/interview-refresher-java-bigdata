# Maven Commands

### Change Version
```shell script
mvn versions:set -DnewVersion=01234-SNAPSHOT
```

### Clean Install - Skipping Test
```shell script
mvn clean install -DskipTests -Dmaven.javadoc.skip=true -Dfindbugs.skip=true -Dmaven.clover.skip=true -DskipITs
```

### Deploy Docker Image
```shell script
mvn clean package -Dfindbugs.skip=true  docker:stop docker:build docker:start  docker:logs -Ddocker.follow -Ddocker.logDate=DEFAULT -Dmaven.test.skip=true
```

### Assembly Plugin

```xml
 <plugin>
        <artifactId>maven-assembly-plugin</artifactId>
        <configuration>
          <archive>
            <manifest>
              <!-- <mainClass></mainClass> -->
            </manifest>
          </archive>
          <descriptorRefs>
            <descriptorRef>jar-with-dependencies</descriptorRef>
          </descriptorRefs>
        </configuration>
        <executions>
          <execution>
            <id>make-assembly</id> <!-- this is used for inheritance merges -->
            <phase>package</phase> <!-- bind to the packaging phase -->
            <goals>
              <goal>single</goal>
            </goals>
          </execution>
        </executions>
      </plugin>
```

```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-compiler-plugin</artifactId>
    <configuration>
        <source>8</source>
        <target>8</target>
    </configuration>
</plugin>
```

# Git Commands

## Show All the Git Configuration
`git config --list --show-origin`

## Un-stage commit 
`git restore --staged`

## The local config file is in the project directory: 
`.git/config`

## The global config file in your home directory: 
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


# GitLab
A Gitlab CI has multiple stages, we can specify stages by <br/>

```yaml
stages: 
- run
- build
- test
```
A Job is tied with the stage, by specifying the stage name.
A Stage can have one more job.

```yaml
job-one:
  image: docker:latest
  stage: run

job-two:
  image: docker:latest
  stage: run
```
  

