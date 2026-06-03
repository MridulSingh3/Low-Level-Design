interface Coffee{
    int getCost();
    
    String getDescription();
}
class SimpleCoffee implements Coffee{
    public int getCost(){
        return 100;
    }
    public String getDescription(){
        return "Simple Coffee";
    }
}
abstract class CoffeeDecorator implements Coffee{
    protected Coffee coffee;
    
    public CoffeeDecorator(Coffee coffee){
        this.coffee=coffee;
    }
}
class MilkDecorator extends CoffeeDecorator{
    public MilkDecorator(Coffee coffee){
        super(coffee);
    }
    public int getCost(){
        return coffee.getCost()+20;
    }
    public String getDescription(){
        return coffee.getDescription()+", Milk";
    }
}
class SugarDecorator extends CoffeeDecorator{
    public SugarDecorator(Coffee coffee){
        super(coffee);
    }
    public int getCost() {
        return coffee.getCost()+10;
    }
    public String getDescription() {
        return coffee.getDescription() + ", Sugar";
    }
}
public class Main{
    public static void main(String[] args){
        Coffee coffee=new SugarDecorator(new MilkDecorator(new SimpleCoffee()));
        System.out.println(coffee.getDescription());
        System.out.println(coffee.getCost());
    }
}