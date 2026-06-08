import java.util.*;
interface FoodDelivery{
    void Order(String foodItem);
}
class VegBurger implements FoodDelivery{
    @Override
    public void Order(String foodItem){
        System.out.println("I Ordered "+foodItem);
    }
}
class Pizza implements FoodDelivery{
    @Override
    public void Order(String foodItem){
        System.out.println("I Ordered "+foodItem);
    }
}
class GarlicBread implements FoodDelivery{
    @Override
    public void Order(String foodItem){
        System.out.println("I Ordered "+foodItem);
    }
}
class FoodDeliveryFactory{
    public FoodDelivery getFood(String foodType){
        if(foodType.equalsIgnoreCase("VEGBURGER")){
            return new VegBurger();
        }
        else if(foodType.equalsIgnoreCase("PIZZA")){
            return new Pizza();
        }
        else if(foodType.equalsIgnoreCase("GARLICBREAD")){
            return new GarlicBread();
        }
        return null;
    }
}
interface PaymentStrategy{
    void pay();
}
class Gpay implements PaymentStrategy{
    @Override
    public void pay(){
        System.out.println("Payment method: GPAY");
    }
}
class Paytm implements PaymentStrategy{
    @Override
    public void pay(){
        System.out.println("Payment method: Paytm");
    }
}
class Payment{
    private PaymentStrategy payment;
    
    public Payment(PaymentStrategy payment){
        this.payment=payment;
    }
    public void payment(){
        payment.pay();
    }
}

interface Observer{
    void update(String status);
}
class MobileUser implements Observer{
    @Override
    public void update(String status){
        System.out.println("Mobile Notification: " + status);
    }
}
class EmailUser implements Observer{
    @Override
    public void update(String status){
        System.out.println("Email Notification: " + status);
    }
}
interface Subject{
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObserver();
}
class Notification implements Subject{
    List<Observer>observers=new ArrayList<>();
    private String notification;
    
    @Override
    public void addObserver(Observer observer){
        observers.add(observer);
    }
    
    @Override
    public void removeObserver(Observer observer){
        observers.remove(observer);
    }
    
    @Override
    public void notifyObserver(){
        for(Observer observer:observers){
            observer.update(notification);
        }
    }
    
    public void setNotification(String notification){
        this.notification = notification;
        notifyObserver();
    }
}
class Logger{
    private static Logger instance;
    private Logger(){}

    public static synchronized Logger getInstance(){
        if(instance==null){
            instance=new Logger();
        }
        return instance;
    }

    public void log(String msg){
        System.out.println(msg);
    }
}
public class Main{
	public static void main(String[] args) {
		FoodDeliveryFactory factory=new FoodDeliveryFactory();
		FoodDelivery f1=factory.getFood("VegBurger");
		
		f1.Order("Veg Burger");
		
		Payment payment=new Payment(new Gpay());

        payment.payment();
        
        Logger logger = Logger.getInstance();
        logger.log("Food Ordered");
        
        Notification notification = new Notification();
        Observer mobile = new MobileUser();
        Observer email = new EmailUser();
        notification.addObserver(mobile);
        notification.addObserver(email);
        notification.setNotification("Order Out For Delivery");
	}
}