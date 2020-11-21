package com.dpins.springbootawssqs.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder;

@Configuration
public class AwsSqsConfig {

	 @Value("${cloud.aws.region.static}")
	    private String region;

	    @Value("${cloud.aws.credentials.access-key}")
	    private String awsAccessKey;

	    @Value("${cloud.aws.credentials.secret-key}")
	    private String awsSecretKey;

	    @Bean
	    public QueueMessagingTemplate queueMessagingTemplate() {
	        return new QueueMessagingTemplate(amazonSQSAsync());
	    }
	    
	    @Primary
	    @Bean
	    public AmazonSQSAsync amazonSQSAsync() {
	        return AmazonSQSAsyncClientBuilder.standard().withRegion(Regions.EU_WEST_1)
	                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(awsAccessKey, awsSecretKey)))
	                .build();
	    }
	
}
