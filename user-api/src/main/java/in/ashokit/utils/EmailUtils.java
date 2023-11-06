package in.ashokit.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;

/*
In this module we use email in two scenorioes
1. for user registration success
2. for forget password , we send new pw

if the mail is sent successfully then return true or else return false

* */

@Component
public class EmailUtils {
    @Autowired
    private JavaMailSender mailSender;

    public boolean sendEmail (String to, String subject, String body){
        boolean isSent = false;
        try {
            MimeMessage msg = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(msg);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(body, true);
            mailSender.send(msg);
            isSent = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSent;
    }


}
