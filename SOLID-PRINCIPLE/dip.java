interface MessageService {
    void sendMessage();
}

class EmailService implements MessageService {
    public void sendMessage() {
        System.out.println("Sending Email");
    }
}

class SMSService implements MessageService {
    public void sendMessage() {
        System.out.println("Sending SMS");
    }
}

class Notification {
    private MessageService service;

    public Notification(MessageService service) {
        this.service = service;
    }

    public void notifyUser() {
        service.sendMessage();
    }
}

public class dip {
    public static void main(String[] args) {
        MessageService service = new EmailService();

        Notification notification = new Notification(service);

        notification.notifyUser();
    }
}