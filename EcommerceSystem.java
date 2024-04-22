import java.util.Scanner;
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
class ElectronicProduct extends product {
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
class ClothingProduct extends product {
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
 class BookProduct extends product{
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
 class customer{
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
 class cart {
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
    public product[] getProductArray() {
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
    public void deleteProduct() {

        Scanner input = new Scanner(System.in);
        System.out.println("Would you like to remove any product from the cart? (1-yes, 2-no)");
        int choice = input.nextInt();
        if (choice == 1) {
            System.out.println("Which product would you like to remove?");
            for (int i = 0; i < nProducts; i++) {
                if (productarray[i] != null) {
                    System.out.println((i + 1) + "- " + productarray[i].getName());
                }
            }
            int productIndex = input.nextInt();
            if (productIndex >= 1 && productIndex <= nProducts && productarray[productIndex - 1] != null) {
                System.out.println(productarray[productIndex - 1].getName() + " removed from the cart.");
                productarray[productIndex - 1] = null;
            } else {
                System.out.println("Invalid product index.");
            }
        }
        product[] remainingProducts = productarray;
        System.out.println("Remaining products in the cart:");
        for (int i = 0; i < remainingProducts.length; i++) {
            product product = remainingProducts[i];
            if (product != null) {
                System.out.println(product.getName() + " - $" + product.getPrice());
            }
        }
    }
    public float calculateTotalPrice() {
        float totalPrice = 0;
        for (int i = 0; i < nProducts; i++) {
            if (productarray[i] != null) {
                totalPrice += productarray[i].getPrice();
            }
        }
        return totalPrice;
    }
    public void placeOrder() {
        Scanner input = new Scanner(System.in);
        System.out.println("Your total price is: $" + calculateTotalPrice());
        System.out.println("Would you like to place the order? (1-yes, 2-no)");
        int choice = input.nextInt();
        if (choice == 1) {
            System.out.println("Order placed successfully!");
            order order=new order(costumerId,1);
            order.orderInfo(productarray);
        } else if (choice == 2) {
            System.out.println("Order canceled.");
        } else {
            System.out.println("Invalid choice.");
        }
    }
}
 class order {
    int customerId;
    int orderId;
    product[] products;
    float totalPrice;
    public order() {

    }
    public order(int cId, int oId) {
        customerId = cId;
        orderId = oId;
    }
    public void orderInfo(product[] products) {
        System.out.println("Order details:");
        System.out.println("Customer ID: " + customerId);
        System.out.println("Products Ordered:");
        for (int i = 0; i < products.length; i++) {
            product product = products[i];
            if (product != null) {
                if (product != null) {
                    System.out.println(product.name + " - $" + product.price);
                    totalPrice += product.getPrice();
                }
            }
        }
        System.out.println("Total Price: $" + totalPrice);
    }
}

 class EcommerceSystem {
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
        cart.deleteProduct();

        cart.placeOrder();

    }
}
    
                    