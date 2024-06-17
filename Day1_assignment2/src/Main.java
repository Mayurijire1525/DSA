public class Main {
    public static void main(String[] args) {

        LinkedList plist = new LinkedList();

        plist.insertEle(new Product(1,"Mouse",10,700));
		plist.insertEle(new Product(2,"Keyboard",15,1000));
		plist.insertEle(new Product(3,"Pendrive",8,600));
		plist.insertEle(new Product(4,"SSD",50,3000));
		plist.insertEle(new Product(5,"RAM",9,2500));
		
		plist.displayProducts();
    }
}