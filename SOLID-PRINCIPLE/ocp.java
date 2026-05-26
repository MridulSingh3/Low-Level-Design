interface Discount{
    double giveDiscount(double amount);
}
class RegularDiscount implements Discount{
    public double giveDiscount(double amount){
        return amount*0.10;
    }
}
class PremiumDiscount implements Discount{
    public double giveDiscount(double amount){
        return amount*0.30;
    }
}
class DiscountService{
    public void printDiscount(Discount discount, double amount) {
        double result = discount.giveDiscount(amount);
        System.out.println("Discount: " + result);
    }
}
public class Main{
	public static void main(String[] args) {
		DiscountService service = new DiscountService();

        Discount regular = new RegularDiscount();
        service.printDiscount(regular, 5000);

        Discount premium = new PremiumDiscount();
        service.printDiscount(premium, 5000);
	}
}