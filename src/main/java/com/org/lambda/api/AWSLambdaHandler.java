package com.org.lambda.api;

import org.springframework.cloud.function.adapter.aws.SpringBootApiGatewayRequestHandler;
import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;

public class AWSLambdaHandler extends SpringBootRequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {
//public class AWSLambdaHandler extends SpringBootApiGatewayRequestHandler {
	
}
