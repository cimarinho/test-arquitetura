# test-arquitetura
Arquitetura Micro-serviço.

1) Start rabbitmq
	sudo service rabbitmq-server start
	sudo service rabbitmq-server stop
	http://localhost:15672/

2) start zipzin
	RABBIT_URI=amqp://localhost java -jar zipkin.jar
	http://localhost:9411/zipkin/


Refresh bus
 	http://localhost:8080/actuator/bus-refresh

eureka
http://localhost:8761/
