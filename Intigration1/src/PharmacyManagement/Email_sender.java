/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PharmacyManagement;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message.RecipientType;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author USER
 */
public class Email_sender {

    static String to;
    static String mesage;

    public static void get_sum(String t, String m) {

        mesage = m;
        to = t;
        TO = to;
        TEXT = mesage;
    }

    private static String HOST = "smtp.gmail.com";//
   // private static String HOST = "173.194.202.108";
    private static String USER = "sulaimanshospital1942@gmail.com";
    private static String PASSWORD = "sulaiman";

    private static String PORT = "465";//587//"465"
    private static String FROM = "sulaimanshospital1942@gmail.com";
    private static String TO;// = from;

    private static String STARTTLS = "true";
    private static String AUTH = "true";
    private static String DEBUG = "true";
    private static String SOCKET_FACTORY = "javax.net.ssl.SSLSocketFactory";
    private static String SUBJECT = "Purcasing Order From Sulaimans Hospitial";
    private static String TEXT;// = mesage;

    public static synchronized void send() {
        //Use Properties object to set environment properties
        Properties props = new Properties();
        props.put("mail.transport.protocol", "smtp");
          props.put("mail.smtp.starttls.enable", STARTTLS);
        
       
        props.put("mail.smtp.host", HOST);
        props.put("mail.smtp.port", PORT);
      
        props.put("mail.smtp.user", USER);
        props.put("mail.smtp.password", PASSWORD);
        props.put("mail.smtp.auth", AUTH);
        /*
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        */
// props.put("mail.transport.protocol", "smtp");s
//props.put("mail.smtp.host", "smtp.gmail.com"); // smtp.gmail.com?
//props.put("mail.smtp.port", "25");
       

        props.put("mail.smtp.debug", DEBUG);

        props.put("mail.smtp.socketFactory.port", PORT);
        props.put("mail.smtp.socketFactory.class", SOCKET_FACTORY);
        props.put("mail.smtp.socketFactory.fallback", "false");
        Authenticator authenticator = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(HOST, PASSWORD);
            }
        };

        //props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        try {

            //Obtain the default mail session
            //SMTPAuthenticator auth = new SMTPAuthenticator();
            Session session = Session.getDefaultInstance(props, authenticator);
            session.setDebug(true);

            //Construct the mail message
            MimeMessage message = new MimeMessage(session);
            message.setText(TEXT);
            message.setSubject(SUBJECT);
            message.setFrom(new InternetAddress(FROM));
            message.addRecipient(RecipientType.TO, new InternetAddress(TO));
            message.saveChanges();

            //Use Transport to deliver the message
            Transport transport = session.getTransport("smtp");
            transport.connect(HOST,465,USER, PASSWORD);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class SMTPAuthenticator extends javax.mail.Authenticator {

        public PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(HOST, PASSWORD);
        }
    }
}
