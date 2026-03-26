package com.example.demo.util;


import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

  private final JavaMailSender mailsender;

  public EmailService(JavaMailSender mailsender){
      this.mailsender=mailsender;

  }
 public void sendBill(String to,Double amount ){

     SimpleMailMessage message = new SimpleMailMessage();
      message.setTo(to);
      message.setSubject("Your Order Bill");
     message.setText(
             "Thank you for your order!\n\n" +
                     "Total Amount: ₹" + amount + "\n\n" +
                     "Food App Team"
     );
 mailsender.send(message);


 }



}
