public class Main {
    public static void main(String[] args) {

        LinkedList l1 = new LinkedList();

        l1.insert(8);
        l1.insert(1);
        l1.insert(2);
        l1.insert(5);
        l1.insert(7);
        l1.insert(4);
        
        l1.display();
        
        System.out.println("Max element="+l1.maxele());
        System.out.println("Minumum element="+l1.minele());
        System.out.println("Sum of even elements="+l1.sumofeven());

    }
}