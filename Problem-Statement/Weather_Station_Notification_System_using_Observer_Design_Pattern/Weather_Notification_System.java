import java.util.*;

interface Observer{
    void update(int temperature);
}
class PhoneDisplay implements Observer{
    @Override
    public void update(int temperature){
        System.out.println("Phone Display Temparture: "+ temperature);
    }
}
class TVDisplay implements Observer{
    @Override
    public void update(int temperature){
        System.out.println("TV Display Temparture: "+ temperature);
    }
}
interface Subject{
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObserver();
}

class WeatherStation implements Subject{
    private List<Observer>observers=new ArrayList<>();
    private int temperature;
    
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
            observer.update(temperature);
        }
    }
    public void setTemperature(int temperature){
        this.temperature=temperature;
        notifyObserver();
    }
}
public class Main{
	public static void main(String[] args) {
		WeatherStation station=new WeatherStation();
		
		Observer phone=new PhoneDisplay();
		Observer tv=new TVDisplay();
		
		station.addObserver(phone);
		station.addObserver(tv);
		
		station.setTemperature(35);
	}
}