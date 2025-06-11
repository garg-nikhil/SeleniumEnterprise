package utils;

import java.io.IOException;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailUtil {

  public static void sendEmail(String to, String subject, String body, String attachmentPath)
      throws MessagingException {
    String from = System.getenv("EMAIL_USER"); // Set your email and password as env variables
    String password = System.getenv("EMAIL_PASSWORD");

    Properties props = new Properties();
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.port", "587");

    Session session =
        Session.getInstance(
            props,
            new Authenticator() {
              protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
              }
            });

    Message msg = new MimeMessage(session);
    msg.setFrom(new InternetAddress(from));
    msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
    msg.setSubject(subject);

    Multipart multipart = new MimeMultipart();

    MimeBodyPart textPart = new MimeBodyPart();
    textPart.setText(body);
    multipart.addBodyPart(textPart);

    if (attachmentPath != null && !attachmentPath.isEmpty()) {
      MimeBodyPart attachmentPart = new MimeBodyPart();
      try {
        attachmentPart.attachFile(attachmentPath);
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
      multipart.addBodyPart(attachmentPart);
    }

    msg.setContent(multipart);
    Transport.send(msg);
  }
}
