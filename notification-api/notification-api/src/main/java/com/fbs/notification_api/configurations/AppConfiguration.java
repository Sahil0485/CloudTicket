package com.fbs.notification_api.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.Thymeleaf;

import java.util.HashMap;
import java.util.Properties;

@Configuration
public class AppConfiguration {

    @Bean // used to save HashMap object inside IOC container
    public HashMap<Integer, Integer> generateHashMap(){
        return new HashMap<>();
    }

    @Bean // JavaMailSender is the class or library used to send mails to emailIds
    public JavaMailSender generateJavaMailSender(){
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost("smtp.gmail.com"); // my mail belongs to gmail i.e., host is smtp.gmail.com
        javaMailSender.setPort(587); // to send mail from pc we require port, and we are using 587 port
    //    javaMailSender.setUsername("cloudticket@gmail.com"); // by what email spring application will send mail to the users
    //    javaMailSender.setPassword("cloud@mail"); // it is app password not actual password
        javaMailSender.setUsername("sahil20120067926thakur@gmail.com");
        javaMailSender.setPassword("ainvyikdlgigckmwmzowz");
        Properties props = javaMailSender.getJavaMailProperties();
        props.put("mail.smtp.auth", "true"); // our springboot api will connect gmail to send email via password so, mail.smtp.auth needs to be true
        props.put("mail.smtp.starttls.enable", "true"); // this property is required for secure connection
        return javaMailSender;
    }

    @Bean
    public TemplateEngine generateThymeleaf(){
        return new TemplateEngine();
    }
}
