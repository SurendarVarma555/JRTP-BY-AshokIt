package in.ashokit.utils;

import jakarta.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class EmailUtils {

    private static final Logger logger = LoggerFactory.getLogger(EmailUtils.class);
    @Autowired
    private JavaMailSender mailSender;

    public boolean sendEmail (String to, String subject, String body, File file){

        boolean isSent = false;

        try {
            MimeMessage msg = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(msg, true);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(body, true);
            if (file != null) {
                helper.addAttachment(file.getName(), file);
            }
            mailSender.send(msg);
            isSent = true;
        } catch (Exception e) {
            logger.error("Error occurred while sending email.", e);
        }
        return isSent;

    }


}
