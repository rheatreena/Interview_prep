/**
 * @author trinapal
 */

/*
This is consumer class implementation
 */
public class ClientApplication implements Consumer{

    //private EmailService emailService = new EmailService(); //this is not a better way.
    /* better way */
    private EmailService emailService;
    private MessageService messageService;

    ClientApplication(EmailService emailService){
        this.emailService = emailService;
    }

     ClientApplication(MessageService messageService){
        this.messageService = messageService;
     }
    public void processMail(String recipient, String message){
        this.emailService.sendMail(recipient,message);
        System.out.println("email sent successfully");
    }

    @Override
    public void processMessage(String to, String message) {
    this.messageService.sendMessage(to, message);
    }
}
