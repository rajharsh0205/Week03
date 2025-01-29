package singlylinkedlist.inventorymanagementsystem;

public class InventoryNodeMethod {
    InventoryNode root; // Head of the inventory list

    // Add an item to the inventory list at a specified position
    public void add(String itemName, int itemID, int quantity, double price, int pos) {
        InventoryNode templ = new InventoryNode(itemName, itemID, quantity, price);

        if (pos == 0) { // Insert at the head
            templ.next = root;
            root = templ;
            return;
        }

        InventoryNode current = templ;
        int currentIndex = 0;

        while (current != null && currentIndex < pos - 1) {
            current = current.next;
            currentIndex++;
        }

        if (current == null) { // Invalid position
            System.out.println("Invalid position: " + pos);
            return;
        }

        // Insert at the specified position
        templ.next = current.next;
        current.next = templ;
    }

    // Display all items in the inventory
    public void display() {
        if (root == null) {
            System.out.println("Inventory is empty.");
            return;
        }

        InventoryNode t = root;
        while (t != null) {
            System.out.println("Item Name: " + t.itemName);
            System.out.println("Item ID: " + t.itemID);
            System.out.println("Quantity: " + t.quantity);
            System.out.println("Price: " + t.price);
            System.out.println();
            t = t.next;
        }
    }

    // Delete an item from the inventory using its itemID
    public void delete(int itemID) {
        if (root == null) {
            System.out.println("Inventory is empty. Nothing to delete.");
            return;
        }

        if (root.itemID == itemID) { // Delete the head node
            root = root.next;
            System.out.println("Item with itemID " + itemID + " deleted.");
            return;
        }

        InventoryNode current = root;
        InventoryNode previous = null;

        while (current != null && current.itemID != itemID) {
            previous = current;
            current = current.next;
        }

        if (current == null) { // Item not found
            System.out.println("Item with ItemID " + itemID + " not found.");
            return;
        }

        previous.next = current.next; // Remove the node
        System.out.println("Item with itemID " + itemID + " deleted.");
    }

    // Display an item by its itemID
    public void displayByItemID(int itemID) {
        if (root == null) {
            System.out.println("Inventory is empty.");
            return;
        }

        InventoryNode t = root;
        while (t != null) {
            if (t.itemID == itemID) {
                System.out.println("Details of item with itemID " + itemID + ":");
                System.out.println("Name: " + t.itemName);
                System.out.println("ID: " + t.itemID);
                System.out.println("Quantity: " + t.quantity);
                System.out.println("Price: " + t.price);
                return;
            }
            t = t.next;
        }

        System.out.println("Item with itemID " + itemID + " not found.");
    }

    // Update the quantity of an item
    public void upgradeGrade(int itemID, int finalQuantity) {
        if (root == null) {
            System.out.println("Inventory is empty.");
            return;
        }

        InventoryNode t = root;
        while (t != null) {
            if (t.itemID == itemID) {
                t.quantity = finalQuantity;
                System.out.println("Quantity of item with itemID " + itemID + " updated to " + finalQuantity + ".");
                return;
            }
            t = t.next;
        }

        System.out.println("Item not found.");
    }

    // Calculate the total value of inventory
    public double total(InventoryNode root) {
        if (root == null) {
            System.out.println("Inventory is empty.");
        }

        double total = 0.0;
        InventoryNode current = root;

        while (current != null) {
            total += current.price * current.quantity;
            current = current.next;
        }

        return total;
    }

    // Sort the inventory based on item prices (Bubble Sort)
    public void sort() {
        if (root == null) {
            System.out.println("Inventory is empty.");
            return;
        }

        InventoryNode current = root;
        InventoryNode index = null;

        while (current != null) {
            index = current.next;

            while (index != null) {
                if (current.price > index.price) {
                    // Swap node values
                    String tempName = current.itemName;
                    int tempID = current.itemID;
                    int tempQuantity = current.quantity;
                    double tempPrice = current.price;

                    current.itemName = index.itemName;
                    current.itemID = index.itemID;
                    current.quantity = index.quantity;
                    current.price = index.price;

                    index.itemName = tempName;
                    index.itemID = tempID;
                    index.quantity = tempQuantity;
                    index.price = tempPrice;
                }
                index = index.next;
            }
            current = current.next;
        }

        System.out.println("Inventory sorted by price.");
    }
}
