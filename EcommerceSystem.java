import java.util.Scanner;
public class EcommerceSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ElectronicProduct e1 = new ElectronicProduct(1, 599.99f, "smartphone", "samsung", 1);
        ClothingProduct cp1 = new ClothingProduct(2, 19.99f, "T-shirt", "Medium", "Cotton");
        BookProduct b1 = new BookProduct(3, 39.99f, "OOP", "O'Reilly", "X Publication");
        System.out.println("Welcome to E-commerce System!");
        System.out.println("please enter your ID: ");
        int customerId = input.nextInt();
        System.out.println("please enter your name: ");
        String customerName = input.next();
        System.out.println("please enter your address ");
        String customerAddress = input.next();
        customer customer = new customer(customerId, customerName, customerAddress);
        System.out.println("How many products you want to add to your cart?");
        int nProduct = input.nextInt();
        cart cart = new cart(customer.getCustomerId(), nProduct);
        for (int i = 0; i < nProduct; i++) {
            System.out.println("Which product would you like to add? 1- Smartphone 2- T-shirt 3- OOP ");
            int type = input.nextInt();
            switch (type) {
                case 1:
                    cart.addProduct(e1);
                    break;
                case 2:
                    cart.addProduct(cp1);
                    break;
                case 3:
                    cart.addProduct(b1);
                    break;
                default:
                    System.out.println("invalid product type");
                    break;
            }
        }

        cart.placeOrder();

    }
}
class product{
    int productId;
    float price;
    String name;
    public product(){

    }
    public product(int pId,float p,String n){
            productId=Math.abs(pId);
            price=Math.abs(p);;
            name=n;

    }
    public void setProductId(int productId){
        this.productId=Math.abs(productId);
    }
    public void setAddress(float price){
        this.price=Math.abs(price);
    }
    public void setName(String name){
         this.name=name;
     }
     public int getProductId(){
        return productId;
     }
     public String getName(){
        return name;
     }
     public float getPrice(){
        return price;
     }




 }
 public class ElectronicProduct extends product {
    String brand;
    int warrantyPeriod;
    public ElectronicProduct(){

    }
    public ElectronicProduct(int pId,float p,String n,String b,int w)
    { super(pId,p,n);
        brand=b;
            warrantyPeriod = Math.abs(w);
        }
    public void setBrand(String brand){
        this.brand=brand;

    }
    public void setWarrantyPeriod(int warrantyPeriod){
        this.warrantyPeriod=Math.abs(warrantyPeriod);
    }
    public int getWarrantyPeriod(){
        return warrantyPeriod;
    }
    public String getBrand(){
        return brand;
    }



}
public class ClothingProduct extends product {
    String size;
    String fabric;
    public ClothingProduct(){

    }
    public ClothingProduct(int pId,float p,String n,String s,String f)
    { super(pId,p,n);
        size=s;
        fabric=f;

    }
    public void setSize(String size){
        this.size=size;
    }
    public void setFabric(String fabric){
        this.fabric=fabric;
    }
    public String getSize(String size){
        return size;
    }
    public String getFabric(String fabric){
        return fabric;
    }


}
public class BookProduct extends product{
    String author;
    String publisher;
    public BookProduct(){

    }
    public BookProduct(int pId,float p,String n,String a,String  pu){
        super(pId,p,n);
        author=a;
        publisher=pu;
    }
    public void setAuthor(String author){
        this.author=author;
    }
    public void setPublisher(String publisher){
        this.publisher=publisher;
    }
    public String getAuthor(){
        return author;
    }
    public String getPublisher(){
        return publisher;
    }


}
public class customer{
    int customerId;
    String Name;
    String address;
    public customer(){

    }
    public customer(int cId,String cn,String a){
        customerId=Math.abs(cId);
        Name=cn;
        address=a;

    }
    public void setCustomerId(int customerId){
        this.customerId=Math.abs(customerId);
    }
    public void setAddress(String address){
        this.address=address;
    }
    public void setName(String Name){
        this.Name=Name;
    }
    public int getCustomerId(){
        return customerId;
    }
    public String getName(){
        return Name;
    }
    public String getAddress(){
        return address;
    }

}
public class cart {
    Scanner input = new Scanner(System.in);
    int costumerId;
    int nProducts;
    product[] productarray;

    public cart() {

    }

    public cart(int cId, int np) {
        costumerId = Math.abs(cId);
        nProducts = Math.abs(np);
        productarray = new product[nProducts];
    }

    public void setCostumerId(int costumerId) {
        this.costumerId = Math.abs(costumerId);
    }

    public void setNProducts(int nProducts) {
        this.nProducts = Math.abs(nProducts);
    }

    public void setProductArray(product[] products) {
        this.productarray = products;
    }

    public int getCostumerId() {
        return costumerId;
    }

    public int getNProducts() {
        return nProducts;
    }

    public product[] getProductarray() {
        return productarray;
    }

    public void addProduct(product addedProduct) {
        for (int i = 0; i < productarray.length; i++) {
            if (productarray[i] == null) {
                productarray[i] = addedProduct;
                return;
            }
        }
    }

    public void removeProduct(product removedProduct) {
        boolean found = false;
        for (int i = 0; i < nProducts; i++) {
            if (productarray[i] == removedProduct) {
                for (int j = i; j < nProducts - 1; j++) {
                    productarray[j] = productarray[j + 1];
                }
                productarray[nProducts - 1] = null;
                nProducts--;
                found = true;
                System.out.println(removedProduct.getName() + " removed from the cart.");
                break;
            }
        }
        if (!found) {
            System.out.println("Product not found in the cart.");
        }
    }

    public float calculateTotalPrice() {
        float totalPrice = 0;
        for (int i = 0; i < nProducts; i++) {
            totalPrice += productarray[i].getPrice();
        }
        return totalPrice;
    }

    public order placeOrder() {
        Scanner input = new Scanner(System.in);
        System.out.println("Your total price is: $" + calculateTotalPrice());
        System.out.println("Would you like to place the order? (1-yes, 2-no)");
        int choice = input.nextInt();
        if (choice == 1) {
            System.out.println("Order placed successfully!");
            order order = new order(costumerId, 1);
            order.products = productarray;
            order.totalPrice = calculateTotalPrice();
            order.printOrderInfo();
            return order;
        } else if (choice == 2) {
            System.out.println("Order canceled.");
        } else {
            System.out.println("Invalid choice.");
        }
        return null;
    }
}
public class order  {
    int customerId;
    int orderId;
    product[]products;
    float totalPrice;
    public order(){

    }
    public order(int cId,int oId){
        customerId=cId;
        orderId=oId;
    }
    public void printOrderInfo() {
        System.out.println("Customer ID: " + customerId);
        System.out.println("Order ID: " + orderId);
        System.out.println("Products:");
        if (products.length == 0) {
            System.out.println("No products in the order.");
        } else {
            for (int i = 0; i < products.length; i++) {
                product product = products[i];
                System.out.println(product.name + " - $" + product.price);
            }
        }
        System.out.println("Total Price: $" + totalPrice);
    }

}

