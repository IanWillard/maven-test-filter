# maven-test-filter
Provides simple shorthand methods of defining filtering of tests based on arbitrary annotations.

# Usage
It is easiest to bind test-filter:test-filter to a lifecycle phase, for example 'validate'.
If you do not wish to, you may call, eg: mvn test-filter:test-filter test -Dfilter=-db
The plugin will output 2 project variables: includedTestGroups and excludedTestGroups
These variables may be passed to JUnit configuration groups.

A test case OR test suite may be annotated with, eg: @Category(DB.class)

Categories may be defined in the pom.xml, eg:
  <configuration>
    <categories>
      <category>slow=org.ian.tools.maven.test.groups.Slow</category>
      <category>fast=org.ian.tools.maven.test.groups.Fast</category>
      <category>db=org.ian.tools.maven.test.groups.DB</category>
    </categories>
  </configuration>
  
This is shorthand=classname or csv list of classnames

# Example
Example is provided in /example.
You can run the example with, eg: mvn clean test -Dfilter=-db,+slow
