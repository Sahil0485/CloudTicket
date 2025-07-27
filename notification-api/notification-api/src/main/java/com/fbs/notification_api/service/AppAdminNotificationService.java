package com.fbs.notification_api.service;

import com.fbs.notification_api.controllers.AppAdminNotificationController;
import com.fbs.notification_api.dto.AirlineRegistrationReqDto;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Slf4j
@Service
public class AppAdminNotificationService {

    JavaMailSender javaMailSender;
    TemplateEngine templateEngine;

    @Autowired
    public AppAdminNotificationService(JavaMailSender javaMailSender, TemplateEngine templateEngine){
        this.javaMailSender = javaMailSender;
        this.templateEngine = templateEngine;
    }

    public void sendAirlineRegistrationRequestNotification(AirlineRegistrationReqDto airlineRegistrationReqDto){
        // MimeMessage class is used to set mail content
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        // to set value inside the mime message we need mimeMessageHelper class
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);

        Context context = new Context(); // used to set values of html template
        context.setVariable("airlineName", airlineRegistrationReqDto.getAirline().getAirlineName());
        context.setVariable("companyName", airlineRegistrationReqDto.getAirline().getCompanyName());
        context.setVariable("website", airlineRegistrationReqDto.getAirline().getWebsite());
        context.setVariable("employees", airlineRegistrationReqDto.getAirline().getEmployees());
        context.setVariable("totalFlights", airlineRegistrationReqDto.getAirline().getTotalFlights());
        context.setVariable("airlineAdminName", airlineRegistrationReqDto.getAirline().getAdmin().getName());
        context.setVariable("adminEmail", airlineRegistrationReqDto.getAirline().getAdmin().getEmail());
        context.setVariable("requestedTime", airlineRegistrationReqDto.getAirline().getCreatedAt().toString());

        String htmlContent = templateEngine.process("airline-registration-request", context); // used for processing html template and pass value using thymeleaf
        try{
            mimeMessageHelper.setTo(airlineRegistrationReqDto.getAdmin().getEmail()); // this method determines the mailId whom we sent email
            mimeMessageHelper.setSubject(airlineRegistrationReqDto.getAirline().getAirlineName() + " registration request");
        //    mimeMessageHelper.setText("Hey, There is the new registration request");
            mimeMessageHelper.setText(htmlContent, true); // for passing html content we pass true for html as second parameter
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        javaMailSender.send(mimeMessage);
    }
}
