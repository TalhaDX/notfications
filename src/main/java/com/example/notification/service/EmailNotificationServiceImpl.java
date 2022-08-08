package com.example.notification.service;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import com.amazonaws.services.simpleemail.model.*;
import com.example.notification.Utils;
import com.example.notification.model.EmailHelper;
import com.example.notification.model.NotificationModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class EmailNotificationServiceImpl implements NotificationService {


    private String accessKey;
    private String secretKey;
    private String region;

    public String senderEmail;

    @Autowired
    private Environment environment;

    @Override
    public void sendMessage(NotificationModel model) {

        setup();

        AmazonSimpleEmailService client = getClient();
        try {
            Destination destination = new Destination();
            destination.setToAddresses(Arrays.asList(model.getEmail())); // TODO: We can easily pass addresses list too

            String subject = EmailHelper.getSubject(model.getReason());
            String body = EmailHelper.getBody(model.getReason());

            SendEmailRequest emailRequest = new SendEmailRequest()
                    .withDestination(destination)
                    .withMessage(new Message(new Content(subject), new Body(new Content(body))))
                    .withSource(senderEmail);
            SendEmailResult result = client.sendEmail(emailRequest);
            System.out.println(result.getMessageId());
        } catch (Exception ex) {
            System.out.println("This email was not sent. Error message :" + ex.getMessage());
        }

    }

    //TODO: Properites can be read in a better way
    private void setup(){
        this.accessKey = Utils.ACCESS_KEY;
        this.secretKey = Utils.SECRET_KEY;
        this.region = Utils.REGION;
        this.senderEmail = Utils.SENDER_EMAIL;

    }

    public AmazonSimpleEmailService getClient(){
        AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);

        AmazonSimpleEmailService client = AmazonSimpleEmailServiceClientBuilder
                .standard().withCredentials(new AWSStaticCredentialsProvider(credentials)).withRegion(region).build();

        return client;
    }
}