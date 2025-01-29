package singlylinkedlist.inventorymanagementsystem;

public class InventoryManagementSystemController {
    public static void main(String[] args) {
        InventoryNodeMethod m = new InventoryNodeMethod();

        // Adding items to the inventory
        m.add("chocolate", 56, 50, 90, 0);
        m.add("jeans", 23, 5, 9078, 0);
        m.add("shirt", 535, 5, 700, 0);
        m.add("dryFruit", 107, 10, 258, 0);
        m.add("sweet", 98, 100, 2500, 0);

        // Display items before sorting
        m.display();

        // Sort items by price and display again
        m.sort();
        m.display();

        // Calculate and display total inventory value
        System.out.println("Total inventory value: " + m.total(m.root));
    }
}
