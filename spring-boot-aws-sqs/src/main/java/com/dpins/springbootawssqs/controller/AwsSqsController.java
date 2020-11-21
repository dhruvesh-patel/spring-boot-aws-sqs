package com.dpins.springbootawssqs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class AwsSqsController {

	@Autowired
    private QueueMessagingTemplate queueMessagingTemplate;

    @Value("${cloud.aws.end-point.uri}")
    private String endpoint;

    @GetMapping("/health")
	public ResponseEntity<String> getHealth() {
		return new ResponseEntity<String>("Successful health check - AWS SQS Service", HttpStatus.OK);
	}
    
    @GetMapping("/send/{message}")
    public void sendMessageToQueue(@PathVariable String message) {
        queueMessagingTemplate.send(endpoint, MessageBuilder.withPayload(message).build());
    }

    @SqsListener("dpinc-queue")
    public void loadMessageFromSQS(String message)  {
        log.info("message from SQS Queue = {}", message);
    }

	
}
