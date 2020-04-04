# Scala Notes

#### What is SBT?
SBT is the build tool for scala project, as we have Maven in Java Project.
SBT can manage dependency same as maven does. 
It also creates a build, runs the test and creates a JAR

## To generate a JAR
sbt package

## To create a Fat or Uber JAR
Install the `assembly plugin`
Inside `/project/plugins.sbt` add

```scala
resolvers += Resolver.url("bintray-sbt-plugins", url("http://dl.bintray.com/sbt/sbt-plugin-releases"))(Resolver.ivyStylePatterns)
addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.14.10")
```

There is no compatibility lookup for the SBT Assembly plugin. <br/>
Hence, Go to : http://dl.bintray.com/sbt/sbt-plugin-releases/com.eed3si9n/sbt-assembly/<br/>

Look for the related Scala & SBT Version and the SBT assembly plugin version. 

