# To run in command line: (Click to see detail)
## add plugin:

  <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-compiler-plugin</artifactId>
            <version>3.5.1</version>
            <configuration>
                <source>1.8</source>
                <target>1.8</target>
            </configuration>
  </plugin> 
  
## add default goal:

  <defaultGoal>install</defaultGoal> 

## run:

mvn install
mvn spring-boot:run
