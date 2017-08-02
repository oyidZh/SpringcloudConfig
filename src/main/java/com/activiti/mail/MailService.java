package com.activiti.mail;

/**
 * Created by 12490 on 2017/8/2.
 */
public interface MailService {

    void sendSimpleMail(String desAddr, String subject, String content);
}
