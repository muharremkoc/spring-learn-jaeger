# spring-learn-jaeger


This Project's Goal,Services Tracing and log monitoring


## Technologies

- Spring
- Docker
- H2 Console
- SpringDoc OpenAPI-UI
- Jaeger

## Installation

- First,Run docker-compose.yml file and Connect Jaeger UI with http://localhost:16686/  

- Second, Define jaeger dependency in pom.xml file

``` java 
		<dependency>
			<groupId>io.opentracing.contrib</groupId>
			<artifactId>opentracing-spring-jaeger-cloud-starter</artifactId>
			<version>3.1.2</version>
		</dependency>
```

- Third Configuring Jaeger settings in application.properties
``` java 

opentracing.jaeger.enabled=true
opentracing.jaeger.service-name=jaeger-service
opentracing.jaeger.udp-sender.host=localhost
opentracing.jaeger.udp-sender.port=6831
opentracing.jaeger.log-spans=true
```


## Usage

- First,Open Jaeger UI


![image](https://user-images.githubusercontent.com/80245013/214865561-9b52a6b7-d6ae-4554-b8d9-5e49882d36c2.png)


- Second Select We used service in Jaeger UI

![image](https://user-images.githubusercontent.com/80245013/214865699-806e4a07-027f-4d78-aca1-ce18be843db4.png)


- Third, If Logger is used we can view the Logs screen, but if we use it we can only look at the time of service requests.

 
   -  Not Used Logger
 
 ![image](https://user-images.githubusercontent.com/80245013/214865921-70ccb9a7-8652-4057-865c-7e39f1ad9bc5.png)
 
 
  -  Used Logger


![image](https://user-images.githubusercontent.com/80245013/214866352-5600654d-858e-416a-b7e1-3451c975b4c1.png)




[Muharrem Koç](https://github.com/muharremkoc)
