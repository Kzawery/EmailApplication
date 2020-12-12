package com.example.validForm;

public interface EmailSender {
    void sendEmail(String to, String subject, String content);
}
