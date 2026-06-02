interface OperationStrategy{
    int operations(int a, int b);
}
class AdditionStrategy implements OperationStrategy{
    public int operations(int a, int b){
        System.out.println("Addition ="+ (a+b));
        return a+b;
    }
}
class SubtractionStrategy implements OperationStrategy{
    public int operations(int a, int b){
        System.out.println("Subtraction ="+ (a-b));
        return a-b;
    }
}
class MultiplicationStrategy implements OperationStrategy{
    public int operations(int a, int b){
        System.out.println("Multiplication ="+ (a*b));
        return a*b;
    }
}
class Calculator{
    private OperationStrategy strategy;
    
    public Calculator(OperationStrategy strategy){
        this.strategy=strategy;
    }
    public int calculate(int a, int b){
        return strategy.operations(a,b);
    }
}
public class Main{
	public static void main(String[] args) {
		Calculator c=new Calculator(new AdditionStrategy());
		c.calculate(3,5);
		
		c=new Calculator(new MultiplicationStrategy());
		c.calculate(3,5);
		
		c=new Calculator(new SubtractionStrategy());
		c.calculate(3,5);
	}
}