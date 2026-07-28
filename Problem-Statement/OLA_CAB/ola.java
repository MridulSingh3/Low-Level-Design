import java.util.*;
class Logger{
    private static Logger instance;
    
    private Logger(){
        System.out.print("new instance Created!");
    }
    
    public static synchronized Logger getInstance(){
        if(instance==null){
            instance=new Logger();
        }
        return instance;
    }
    
    public void setMessage(String message){
        System.out.print(message);
    }
}
abstract class OLA{
    abstract String cab();
}
class MiniCab extends OLA{
    public String cab(){
        return "booked MiniCab!";
    }
}
class Sedan extends OLA{
    public String cab(){
        return "booked Sedan";
    }
}
class SUV extends OLA{
    public String cab(){
        return "booked SUV";
    }
}

class CabFactory{
    public OLA getCab(String Cabtype){
        if(Cabtype.equalsIgnoreCase("MiniCab")){
            return new MiniCab();
        }
        else if(Cabtype.equalsIgnoreCase("Sedan")){
            return new Sedan();
        }
        else if(Cabtype.equalsIgnoreCase("SUV")){
            return new SUV();
        }
        else{
            return null;
        }
    }
}
interface FareStrategy{
    public int faircharge(int km);
}
class NormalFare implements FareStrategy{
    public int faircharge(int km){
        return km*20;
    }
}
class SurgePricing implements FareStrategy{
    public int faircharge(int km){
        return km*50;
    }
}
class PremiumFare implements FareStrategy{
    public int faircharge(int km){
        return km*100;
    }
}

class Strategy{
    private FareStrategy strategy;
    
    public void setStrategy(FareStrategy strategy){
        this.strategy=strategy;
    }
    
    public int perKm(int km){
        return strategy.faircharge(km);
    }
}

interface Observer{
    void update(String status);
}
class Passenger implements Observer{
    private String name;
    
    Passenger(String name){
        this.name=name;
    }
    public void update(String status){
        System.out.print(name+" received notification "+status);
    }
}
class Driver implements Observer{
    private String name;
    Driver(String name){
        this.name = name;
    }
    public void update(String status){
        System.out.println(name + " received notification : " + status);
    }
}
class Admin implements Observer{
    public void update(String status){
        System.out.println("Admin notified : " + status);
    }
}

class Ride{
    ArrayList<Observer>observers=new ArrayList<>();
    public void addObserver(Observer ob){
        observers.add(ob);
    }
    public void removeObserver(Observer ob){
        observers.remove(ob);
    }
    public void setStatus(String status){
        System.out.println("\nRide Status : "+status);
        notifyObservers(status);
    }
    private void notifyObservers(String status){
        for(Observer observer:observers){
            observer.update(status);
        }
    }
}

public class Main{
	public static void main(String[] args) {
		Logger logger=Logger.getInstance();
		CabFactory factory=new CabFactory();
		OLA cab=factory.getCab("SUV");
		
		Strategy strategy = new Strategy();
		strategy.setStrategy(new PremiumFare());
		
		Ride ride = new Ride();
		
		Observer passenger = new Passenger("Mridul");
		Observer driver = new Driver("Rahul");
		Observer admin = new Admin();
		
		ride.addObserver(passenger);
		ride.addObserver(driver);
		ride.addObserver(admin);
		
		logger.setMessage(cab.cab());
		System.out.println("\nFare = " + strategy.perKm(10));

        ride.setStatus("Driver Assigned");
        ride.setStatus("Ride Started");
        ride.setStatus("Ride Completed");
	}
}
