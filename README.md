# task2
Http communication between two services. Uses spring RestTemplate for http communication. By default configured to run on port 8088. Usage : http://localhost:8088/employee/23444

Remote service is configured in application.yml. Currently this is configured to use the service
set up in the test1-task namely : http://localhost:8080/internal-greetings.

The remote service should be started before launching this spring-boot application
