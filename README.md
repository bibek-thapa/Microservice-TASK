# Microservice-TASK
This application is about two microservices and one aggregator. 

CUSTOMERMS and EQUIPMENTMS are two microservices whereas PROFILESERVICE is an aggregator. 
It is called aggregator because it talks with the CUSTOMERMS and EQUIPMENTMS to make a profile. 

Kafka is also used to make a centralized log system. When any microservice or service generates logs , it sends it to topic in Kafka. From there ,
logstash will take care of logs to send to ElasticSearch and finally to Kibana. Making kafka as a centralized log system helps to automate things
and application do not have to worry about complex log synchronizers. 





Technologies Used : 
Spring Boot,CloudConfig,Eureka,Hystrix,Swagger,H2,Kafka,Logback
