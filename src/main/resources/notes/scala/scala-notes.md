# Scala Notes

## What is SBT?
SBT is the build tool for scala project, as we have Maven in Java Project.
SBT can manage dependency same as maven does. 
It also creates a build, runs the test and creates a JAR

## To create a Fat or Uber JAR
Add the `assembly plugin` code
Inside `/project/` folder as `/project/plugins.sbt` 

```scala
resolvers += Resolver.url("bintray-sbt-plugins", url("http://dl.bintray.com/sbt/sbt-plugin-releases"))(Resolver.ivyStylePatterns)
addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.14.10")
```

There is no compatibility lookup for the SBT Assembly plugin. <br/>
Hence, Go to : http://dl.bintray.com/sbt/sbt-plugin-releases/com.eed3si9n/sbt-assembly/<br/>

Look for the related Scala & SBT Version and the SBT assembly plugin version. 


## Dependencies Resolve
```scala
// set the scope to compile to add up the dependency to Fat JAR
 libraryDependencies += "org.apache.poi" % "poi" % "4.1.0" % "compile"

// set the scope to provided which is not required in Far JAR. %% takes mentioned Scala Version
 libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.4.5" % "provided"
```

## SBT Commands
- `sbt`<br/>
Opens up SBT shell, where we can pass various parameters, e.g assembly, package etc. <br/>

- `sbt help`<br/>
Presents us with a list of options<br/>

- `sbt package`<br/>
Creates a JAR file containing the files in 
`src/main/scala`, `src/main/java`, and resources in `src/main/resources`.

- `sbt run`<br/>
Compiles your code, and runs the main class from your project.<br/>

- `sbt compile`<br/>
Compiles source code files that are in src/main/scala, src/main/java, and the root directory of the project.<br/>

- `sbt consoleQuick`<br/>
Starts the Scala interpreter (REPL) with the project dependencies on the classpath.<br/>

