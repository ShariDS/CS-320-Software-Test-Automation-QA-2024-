package Milestone1;

/**
 * The Contact class represents a contact with a unique ID, first name, last name, phone number, and address.
 * Each attribute has character length limitations and cannot be null.
 */
public class Contact {
    private String contactID; // Limit 10 characters
    private String firstName; // Limit 10 characters
    private String lastName; // Limit 10 characters
    private String phoneNumber; // Limit 10 characters
    private String address; // Limit 30 characters

    /**
     * Constructs a Contact object with the given ID, first name, last name, phone number, and address.
     * @param cid the unique ID of the contact, must be non-null and <= 10 characters
     * @param fn the first name of the contact, must be non-null and <= 10 characters
     * @param ln the last name of the contact, must be non-null and <= 10 characters
     * @param pn the phone number of the contact, must be non-null and <= 10 characters
     * @param addr the address of the contact, must be non-null and <= 30 characters
     */
    public Contact(String cid, String fn, String ln, String pn, String addr) {
        if (cid == null || cid.length() > 10) {
            throw new IllegalArgumentException("Invalid contact ID - null or length > 10");
        }
        if (fn == null || fn.length() > 10) {
            throw new IllegalArgumentException("Invalid first name - null or length > 10");
        }
        if (ln == null || ln.length() > 10) {
            throw new IllegalArgumentException("Invalid last name - null or length > 10");
        }
        if (pn == null || pn.length() > 10) {
            throw new IllegalArgumentException("Invalid phone number - null or length > 10");
        }
        if (addr == null || addr.length() > 30) {
            throw new IllegalArgumentException("Invalid address - null or length > 30");
        }
        this.contactID = cid;
        this.firstName = fn;
        this.lastName = ln;
        this.phoneNumber = pn;
        this.address = addr;
    }

    // Getters
    public String getContactID() {
        return contactID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    // Setters
    public void setContactID(String cid) {
        if (cid == null || cid.length() > 10) {
            throw new IllegalArgumentException("Invalid contact ID - null or length > 10");
        }
        this.contactID = cid;
    }

    public void setFirstName(String fn) {
        if (fn == null || fn.length() > 10) {
            throw new IllegalArgumentException("Invalid first name - null or length > 10");
        }
        this.firstName = fn;
    }

    public void setLastName(String ln) {
        if (ln == null || ln.length() > 10) {
            throw new IllegalArgumentException("Invalid last name - null or length > 10");
        }
        this.lastName = ln;
    }

    public void setPhoneNumber(String pn) {
        if (pn == null || pn.length() > 10) {
            throw new IllegalArgumentException("Invalid phone number - null or length > 10");
        }
        this.phoneNumber = pn;
    }

    public void setAddress(String addr) {
        if (addr == null || addr.length() > 30) {
            throw new IllegalArgumentException("Invalid address - null or length > 30");
        }
        this.address = addr;
    }
}