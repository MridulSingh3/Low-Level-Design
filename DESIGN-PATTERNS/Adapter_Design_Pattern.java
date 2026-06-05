interface Notification{
    void send();
} 
class WhatsAppAPI{
    public void sendMeassage(){
        System.out.println("WhatsApp Message Send!");
    }
}
class WhatsAppAdapter implements Notification{
    private WhatsAppAPI whatsappApi;
    
    public WhatsAppAdapter(WhatsAppAPI whatsappApi){
        this.whatsappApi=whatsappApi;
    }
    @Override
    public void send(){
        whatsappApi.sendMeassage();
    }
}
public class Main{
	public static void main(String[] args) {
		Notification notification=new WhatsAppAdapter(new WhatsAppAPI());
        notification.send();
	}
}