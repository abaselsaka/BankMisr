package banquemisr.challenge05.banquemisr.controller;

import banquemisr.challenge05.banquemisr.dto.EmailRequest;
import banquemisr.challenge05.banquemisr.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sendmail")
public class SendMailController {

    @Autowired
    private EmailService emailService;
    @PostMapping("/send")
    public String sendNotification(@RequestBody EmailRequest emailRequest) {
        emailService.sendEmail(emailRequest.getTo(), emailRequest.getSubject(), emailRequest.getText());
        return "Email sent successfully!";
    }
}
