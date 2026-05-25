import java.util.*;
class Product{
    private String name;
    private double price;
    
    public Product(String name, double price){
        this.name=name;
        this.price=price;
    }
    public String getName(){
        return name;
    }
    
    public double getPrice(){
        return price;
    }
}
class ShoppingCart{
    private List<Product>products=new ArrayList<>();
    
    public void addProduct(Product product){
        products.add(product);
    }
    public List<Product> getProducts(){
        return products;
    }
    public double calcPrice(){
        double total=0;
        
        for(Product product:products){
            total+=product.getPrice();
        }
        return total;
    }
}
class InvoiceService {
    public void generateInvoice(ShoppingCart cart){
        System.out.println("----- Invoice -----");
        
        for(Product product:cart.getProducts()){
            System.out.println(
                product.getName() + " : " + product.getPrice()
            );
        }

        System.out.println("-------------------");
        System.out.println("Total: "+cart.calcPrice());
    }
}
class DatabaseService{
    public void saveToDB(ShoppingCart cart){
        System.out.println("Saving cart data to database...");
    }
}
public class Main{
	public static void main(String[] args) {
		Product p1 = new Product("Laptop", 50000);
        Product p2 = new Product("Mouse", 1000);

        ShoppingCart cart = new ShoppingCart();

        cart.addProduct(p1);
        cart.addProduct(p2);

        InvoiceService invoiceService = new InvoiceService();
        invoiceService.generateInvoice(cart);

        DatabaseService databaseService = new DatabaseService();
        databaseService.saveToDB(cart);
	}
}