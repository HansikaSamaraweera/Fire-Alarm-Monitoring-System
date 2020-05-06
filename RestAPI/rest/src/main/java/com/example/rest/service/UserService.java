package com.example.rest.service;

import com.example.rest.model.Sensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private JavaMailSender javaMailSender;

    @Autowired
    public UserService(JavaMailSender javaMailSender){
        this.javaMailSender = javaMailSender;
    }

    public void send(String id)throws MailException {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo("sithijabimsara@gmail.com");
        mail.setFrom("hansika.m99@gmail.com");
        mail.setSubject("Fire Alarm Alert!!!");
        mail.setText("Your room is on fire"+ id);
        javaMailSender.send(mail);

    }
}
