/**
 * Represents a single node in the phone book linked list.
 * Each node contains a contact's name, address, city, phone number,
 * and a reference to the next node in the list.
 */
public class ListNode {
    private String name;        // Stores the contact's full name
    private String address;     // Stores the contact's address
    private String city;        // Stores the city of the contact
    private String phoneNumber; // Stores the contact's phone number
    ListNode next;              // Points to the next node in the list

    /**
     * Constructor to initialize a new node with contact details.
     * 
     * @param name The full name of the contact.
     * @param address The address of the contact.
     * @param city The city of the contact.
     * @param phoneNumber The contact's phone number.
     */
    public ListNode(String name, String address, String city, String phoneNumber) {
        this.name = name;                    // Initialize the name field
        this.address = address;              // Initialize the address field
        this.city = city;                    // Initialize the city field
        this.phoneNumber = phoneNumber;      // Initialize the phone number field
        this.next = null;                    // New node initially points to no other node (end of list)
    }

    // Getter methods to retrieve individual properties of the contact
    public String getName() { return name; }                 // Gets the contact's name
    public String getAddress() { return address; }           // Gets the contact's address
    public String getCity() { return city; }                 // Gets the contact's city
    public String getPhoneNumber() { return phoneNumber; }   // Gets the contact's phone number

    // Setter methods to modify individual properties of the contact
    public void setName(String name) { this.name = name; }                      // Sets a new name for the contact
    public void setAddress(String address) { this.address = address; }          // Sets a new address for the contact
    public void setCity(String city) { this.city = city; }                      // Sets a new city for the contact
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; } // Sets a new phone number

    /**
     * Returns a string representation of the contact details in a readable format.
     * This method can be used to display the contact's information in a nice format.
     * 
     * @return A string containing all the contact details in a formatted way.
     */
    @Override
    public String toString() {
        return "Name: " + name + ", Address: " + address + ", City: " + city + ", Phone: " + phoneNumber;
    }
}