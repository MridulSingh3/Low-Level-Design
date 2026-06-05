class EmailService {
    public void sendEmail() {
        System.out.println("Email Sent");
    }
}

class LoggerService {
    public void log() {
        System.out.println("Logged");
    }
}

class RetryService {
    public void retry() {
        System.out.println("Retry Enabled");
    }
}

class NotificationFacade {
    private EmailService emailService;
    private LoggerService loggerService;
    private RetryService retryService;

    public NotificationFacade() {
        emailService = new EmailService();
        loggerService = new LoggerService();
        retryService = new RetryService();
    }

    public void sendNotification() {
        emailService.sendEmail();
        loggerService.log();
        retryService.retry();
    }
}

public class Facade_Design_Pattern {
    public static void main(String[] args) {
        NotificationFacade facade = new NotificationFacade();
        facade.sendNotification();
    }
}