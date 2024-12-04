/**
 * Manages the linked list of phone book entries, providing functions to add, modify, delete,
 * sort, move, and display phonebook contacts.
 */
public class PhonebookManager {
    private ListNode head; // Head of the linked list, points to the first contact in the phonebook

    /**
     * Adds a new entry to the end of the phonebook list and sorts the list alphabetically by last name.
     * 
     * @param name The full name of the contact (e.g., "John Doe")
     * @param address The address of the contact
     * @param city The city where the contact resides
     * @param phoneNumber The contact's phone number
     */
    public void addEntry(String name, String address, String city, String phoneNumber) {
        // Create a new ListNode with the provided details
        ListNode newNode = new ListNode(name, address, city, phoneNumber);

        // If the list is empty, set the new node as the head of the list
        if (head == null) {
            head = newNode;
        } else {
            // Traverse to the end of the list to add the new node
            ListNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }

        // After adding, sort the list alphabetically by last name
        sortAlphabetically();
    }

    /**
     * Modifies an existing entry's address, city, and phone number by name.
     * 
     * @param name The full name of the entry to modify
     * @param newAddress The new address to set
     * @param newCity The new city to set
     * @param newPhoneNumber The new phone number to set
     */
    public void modifyEntry(String name, String newAddress, String newCity, String newPhoneNumber) {
        ListNode current = head; // Start from the head of the list

        // Traverse the list to find the entry matching the name
        while (current != null) {
            if (current.getName().equalsIgnoreCase(name)) {
                // Update details if the name matches
                current.setAddress(newAddress);
                current.setCity(newCity);
                current.setPhoneNumber(newPhoneNumber);
                System.out.println("Entry modified successfully.");
                return;
            }
            current = current.next;
        }
        System.out.println("Entry not found."); // Print message if no match is found
    }

    /**
     * Deletes an entry from the phonebook by name.
     * 
     * @param name The name of the entry to delete
     */
    public void deleteEntry(String name) {
        // Check if the list is empty
        if (head == null) return;

        // If the head node itself holds the name, remove it by pointing head to the next node
        if (head.getName().equalsIgnoreCase(name)) {
            head = head.next;
            System.out.println("Entry deleted successfully.");
            return;
        }

        // Traverse the list to find the node before the target node
        ListNode current = head;
        while (current.next != null && !current.next.getName().equalsIgnoreCase(name)) {
            current = current.next;
        }

        // Unlink the target node if found
        if (current.next != null) {
            current.next = current.next.next;
            System.out.println("Entry deleted successfully.");
        } else {
            System.out.println("Entry not found.");
        }
    }

    /**
     * Moves all entries from "Bellingham" to "Seattle" in the city field.
     * This is useful for updating the city of contacts in bulk.
     */
    public void moveEntriesToSeattle() {
        ListNode current = head; // Start from the head of the list
        while (current != null) {
            // If the contact is in Bellingham, update the city to Seattle
            if (current.getCity().equalsIgnoreCase("Bellingham")) {
                current.setCity("Seattle");
            }
            current = current.next; // Move to the next contact in the list
        }
        System.out.println("Moved all Bellingham entries to Seattle.");
    }

    /**
     * Sorts the contacts alphabetically by last name using a bubble sort algorithm.
     * Swaps the data between nodes if the current node's last name is lexicographically
     * greater than the next node's last name.
     */
    public void sortAlphabetically() {
        // No sorting needed for an empty list or a single-node list
        if (head == null || head.next == null) return;

        boolean swapped;
        // Bubble sort until no swaps are required (list is sorted)
        do {
            swapped = false;
            ListNode current = head;
            while (current.next != null) {
                // Compare current node's name with the next node's name
                if (current.getName().compareToIgnoreCase(current.next.getName()) > 0) {
                    // Swap data fields of the two nodes if out of order
                    swapData(current, current.next);
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped); // Repeat if a swap was made during traversal
    }

    /**
     * Helper method to swap the data between two nodes. Only the data is swapped, not the nodes themselves.
     * 
     * @param node1 The first node
     * @param node2 The second node
     */
    private void swapData(ListNode node1, ListNode node2) {
        // Temporarily store data of node1
        String tempName = node1.getName();
        String tempAddress = node1.getAddress();
        String tempCity = node1.getCity();
        String tempPhone = node1.getPhoneNumber();

        // Copy data from node2 to node1
        node1.setName(node2.getName());
        node1.setAddress(node2.getAddress());
        node1.setCity(node2.getCity());
        node1.setPhoneNumber(node2.getPhoneNumber());

        // Copy temporary data of node1 into node2
        node2.setName(tempName);
        node2.setAddress(tempAddress);
        node2.setCity(tempCity);
        node2.setPhoneNumber(tempPhone);
    }

    /**
     * Prints all entries in the phonebook in a formatted manner. If the phonebook is empty, it prints a message.
     */
    public void printPhoneBook() {
        // Check if the list is empty and print an appropriate message
        if (head == null) {
            System.out.println("Phonebook is empty.");
            return;
        }

        // Print each contact's details in the list
        ListNode current = head;
        System.out.println("\nPhonebook Entries:");
        while (current != null) {
            System.out.println(current); // Uses ListNode's toString() method to print details
            current = current.next; // Move to the next contact in the list
        }
    }
}