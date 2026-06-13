interface OrderCommand{
    void execute();
}
class Chef{
    public void cookPizza(){
        System.out.println("Chef is preparing Pizza");
    }
    public void cookBurger(){
        System.out.println("Chef is preparing Burger");
    }
    public void cookPasta(){
        System.out.println("Chef is preparing Pasta");
    }
}

class PizzaOrder implements OrderCommand{
    private Chef chef;
    public PizzaOrder(Chef chef){
        this.chef = chef;
    }
    @Override
    public void execute(){
        chef.cookPizza();
    }
}

class BurgerOrder implements OrderCommand{
    private Chef chef;
    public BurgerOrder(Chef chef){
        this.chef = chef;
    }
    @Override
    public void execute(){
        chef.cookBurger();
    }
}

class PastaOrder implements OrderCommand{
    private Chef chef;
    public PastaOrder(Chef chef){
        this.chef = chef;
    }
    @Override
    public void execute(){
        chef.cookPasta();
    }
}

class Waiter{
    private OrderCommand command;
    public void takeOrder(OrderCommand command){
        this.command = command;
    }
    public void placeOrder(){
        command.execute();
    }
}

public class Main{
    public static void main(String[] args){
        Chef chef = new Chef();

        OrderCommand pizza=new PizzaOrder(chef);

        OrderCommand burger=new BurgerOrder(chef);

        OrderCommand pasta=new PastaOrder(chef);

        Waiter waiter=new Waiter();

        waiter.takeOrder(pizza);
        waiter.placeOrder();

        waiter.takeOrder(burger);
        waiter.placeOrder();

        waiter.takeOrder(pasta);
        waiter.placeOrder();
    }
}