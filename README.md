# SAMPLE VERT-X

## Technology stack

- Java 1.8
- JOOQ
- Vertx 3

### Developer setup

- Install Intellij

- Open project

- mvn clean install root project

### Integration test

run `mvn integration-test`

### Metrics and monitoring

- tech used are vertx-metrics, jolokia and hawtio

1. run the app jar `java -javaagent:jolokia-jvm-1.3.3-agent.jar=host=0.0.0.0  -jar target\<jar name>.jar`
2. run hawtio.jar `java -jar hawtio-app-1.4.63.jar --port 8090`
3. open browser `http://localhost:8090/hawtio/`
4. the jolokia should run in this url `http://localhost:8778/jolokia/`






