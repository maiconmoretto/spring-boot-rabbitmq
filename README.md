# spring-boot-rabbitmq

<br><br>
<p><b>A project with spring boot and rabbitMQ (https://www.rabbitmq.com/)</b>, 
<p>based on the core concept of rabbitMq with  a producer, queue and a consumer,
<p>"A producer is a user application that sends messages.
<p>A queue is a buffer that stores messages.
<p>A consumer is a user application that receives messages."
<p>font: https://www.rabbitmq.com/tutorials/tutorial-three-python.html

<p>there is one api for producer(/api/v1/rabbitmq/consumer) 
<p>and one for consumer(/api/v1/rabbitmq/consumer)
<p>i am using rabbitMq with a container in docker --> https://hub.docker.com/_/rabbitmq

<br><br>
<p><b>to run this project:</b>
<p>first start the rabbitMQ container:
<p>after install docker and pull the image from docker hub:
<p>docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3-management
<p>next  
<p>if you have maven installed, on root folder run this command:
<p><b>mvn spring-boot:run</b>
<p>or
<p>execute the .jar:
<p><b>java -jar target/spring-boot-rabbitmq-0.0.1-SNAPSHOT.jar</b> 
<p>then send a request to consumer:
<p>curl -x localhost:8080 http://localhost:8080/api/vi/rabbitmq/consumer
<p>finally send a request to the producer:
<p>curl -x localhost:8080 http://localhost:8080/api/vi/rabbitmq/producer
<p>and checkout the application running will receive the messages every time you execute the sender
  
  

<br><br>
<p>java --version:
<p>openjdk 11.0.7 2020-04-14
<p>OpenJDK Runtime Environment (build 11.0.7+10-post-Ubuntu-2ubuntu218.04)
<p>OpenJDK 64-Bit Server VM (build 11.0.7+10-post-Ubuntu-2ubuntu218.04, mixed mode)
<p>docker --version
<p>Docker version 19.03.11, build dd360c7
<p>RabbitMQ version
<p>3.8.4
<p>linux verson:
<p>Linux maicon-X450LD 4.15.0-54-generic #58-Ubuntu SMP Mon Jun 24 10:55:24 UTC 2019 x86_64 x86_64 x86_64 GNU/Linux
  
