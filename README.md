junk
====

// swift help
```java
mvn org.apache.maven.plugins:maven-dependency-plugin:2.8:get -DremoteRepositories=central::default::http://repo1.maven.apache.org/maven2 -Dartifact=com.facebook.swift:swift-generator-cli:RELEASE:jar:standalone -Ddest=/tmp/

java -jar /tmp/swift-generator-cli-0.14.1-standalone.jar -generate_included_files  -default_package "swift" Service.thrift

```
