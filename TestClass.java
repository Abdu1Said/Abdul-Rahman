import java.util.Scanner;
/**
 * Main class to test the PhonebookManager functionality.
 * Provides a user interface for managing phonebook entries 
 * with options to add, modify, delete, sort, and view entries.
 */
public class TestClass {
    public static void main(String[] args) {
        // Initialize a PhonebookManager instance to manage contacts
        PhonebookManager phonebookManager = new PhonebookManager();
        
        // Scanner for user input
        Scanner scanner = new Scanner(System.in);
        String choice; // Variable to store the user's menu choice

        // Main loop to display options until user decides to exit
        do {
            // Display menu options to the user
            System.out.println("\nPhonebook Manager");
            System.out.println("1. Add Entry");           // Option to add a new contact
            System.out.println("2. Modify Entry");        // Option to modify an existing contact
            System.out.println("3. Delete Entry");        // Option to delete an existing contact
            System.out.println("4. Sort Contacts");       // New option to sort contacts alphabetically
            System.out.println("5. Print Phonebook");     // Option to print all contacts in a formatted view
            System.out.println("6. Exit");                // Option to exit the program
            System.out.print("Enter your choice: ");
            
            // Read the user's choice from input
            choice = scanner.nextLine();

            // Execute corresponding action based on user input
            switch (choice) {
                case "1":
                    // Add a new contact to the phonebook
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine(); // Get contact's full name
                    System.out.print("Enter Address: ");
                    String address = scanner.nextLine(); // Get contact's address
                    System.out.print("Enter City: ");
                    String city = scanner.nextLine(); // Get contact's city
                    System.out.print("Enter Phone Number: ");
                    String phoneNumber = scanner.nextLine(); // Get contact's phone number

                    // Add the new contact to the phonebook and sort automatically
                    phonebookManager.addEntry(name, address, city, phoneNumber);
                    System.out.println("Entry added and sorted alphabetically.");
                    break;

                case "2":
                    // Modify an existing contact in the phonebook
                    System.out.print("Enter Name to Modify: ");
                    name = scanner.nextLine(); // Get name of contact to modify
                    System.out.print("Enter New Address: ");
                    address = scanner.nextLine(); // New address for the contact
                    System.out.print("Enter New City: ");
                    city = scanner.nextLine(); // New city for the contact
                    System.out.print("Enter New Phone Number: ");
                    phoneNumber = scanner.nextLine(); // New phone number for the contact
                    
                    // Modify the contact's details in the phonebook
                    phonebookManager.modifyEntry(name, address, city, phoneNumber);
                    break;

                case "3":
                    // Delete a contact from the phonebook
                    System.out.print("Enter Name to Delete: ");
                    name = scanner.nextLine(); // Get name of contact to delete

                    // Delete the specified contact from the phonebook
                    phonebookManager.deleteEntry(name);
                    break;

                case "4":
                    // Sort all contacts alphabetically by last name
                    phonebookManager.sortAlphabetically();
                    System.out.println("Contacts have been sorted alphabetically.");
                    break;

                case "5":
                    // Print all contacts in the phonebook in a formatted view
                    phonebookManager.printPhoneBook();
                    break;

                case "6":
                    // Exit the program
                    System.out.println("Exiting...");
                    break;

                default:
                    // Handle invalid menu choices
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (!choice.equals("6")); // Continue until user chooses to exit

        scanner.close(); // Close the scanner resource
    }
}