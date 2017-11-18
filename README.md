### Running App
`mvn spring-boot:run`
`mvn spring-boot:run "-Drun.jvmArguments=-Dspring.profiles.active=test,secrets -Dspring.config.location=/Users/cmynam/app-location/secret-props/test/"`
The above command reads application-test.properties from src/main/resources folder and application-secrets.properties 
from specified spring.config.location value.
