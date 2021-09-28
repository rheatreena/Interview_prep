/**
 * @author trinapal
 */
public class Application {

    public static void main(String[] args) {
        ClientApplication clientApplication = new ClientApplication(new EmailService()); //initializing email service - not good
        clientApplication.processMail("Sinli", "I m good");

        //dependency injection
        Injector injector = new SMSInjector() ;
        Consumer app = null;

        app = injector.getConsumer();
        app.processMessage("Singha", "good");

        Injector injector1 = new ChatInjector();
        Consumer app1 = null;

        app1 = injector1.getConsumer();
        app1.processMessage("Grrr" , "chatting");


    }

    //dependency injection will be based on interface or abstract service class - so  that consumer classes have their own implementation. Consumer classes should follow the terms of service.
    //Injector classes will initialize service class and then consumer class

}
