This repo demonstrates how to send message on AWS SQS queue and then consume message using java 11 based spring boot application and spring cloud aws messaging. For Event-driven architectures and asynchonous communication AWS SQS offers a way achieve loose-coupling across multiple services or apps.

Pre-requisite:
1) JDK 11
2) Eclipse / IntelliJ IDE 
3) Maven (if not part of IDE already)
4) Postman (Or swagger or browser - I prefer Postman)

Steps to Setup :

1. Create AWS Free-tier Account using https://portal.aws.amazon.com/billing/signup. 
```
- Create SQS Queue using AWS Console - https://docs.aws.amazon.com/AWSSimpleQueueService/latest/SQSDeveloperGuide/sqs-configure-create-queue.html
- Note down SQS Queue name and Queue URI (you will need to update this in application.properties & controller class)
- Also Get Access key and secret access key from AWS control using https://aws.amazon.com/blogs/security/how-to-find-update-access-keys-password-mfa-aws-management-console/. (you will need to update this in application.properties)
```

2. Clone the application
```
https://github.com/dhruvesh-patel/spring-boot-aws-sqs.git
```
3. Update application.properties with your own values (without this application will not build or start).
```
cloud.aws.credentials.accessKey=xxxxxx
cloud.aws.credentials.secretKey=xxxxxx
cloud.aws.end-point.uri:xxxxxx

Also, Update AwsSqsController.java class "@SqsListener("dpinc-queue")" with your queue name - created in above point 1.
```

4. Build and run the app using IDE / maven
```
mvn clean install 
mvn spring-boot:run
The app will start running - check app health using http://localhost:8621/health.
```
4. Use REST API to send message to queue. 
```
GET http://localhost:8621/send/{message}

For example, http://localhost:8621/send/hellosqs
```

5. When you do this, SQS Listener in will listen to the queue name (use queue name from above point 1) and log will printed with messages published on SQS queue. 

