
## Java Messaging System (JMS)


### Running a broker inside a docker container

This ActiveMQ broker is used: 
https://github.com/vromero/activemq-artemis-docker

Command to run it

```
docker run -it --rm -p 8161:8161 -p 61616:61616 vromero/activemq-artemis
```


