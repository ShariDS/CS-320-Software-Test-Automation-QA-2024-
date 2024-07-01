package Milestone1;

import java.util.ArrayList;

/**
 * The ContactService class provides methods to manage Contact objects, including adding, deleting, and updating contacts.
 */
public class ContactService {
    private final ArrayList<Contact> listOfContacts;

    public ContactService() {
        listOfContacts = new ArrayList<>();
    }

    // Adds a new contact if it does not already exist in the list
    public boolean addContact(Contact entity) {
        for (Contact contact : listOfContacts) {
            if (contact.equals(entity)) {
                return false;
            }
        }
        listOfContacts.add(entity);
        return true;
    }

    // Deletes a contact by its ID
    public boolean deleteContact(String cid) {
        for (Contact contact : listOfContacts) {
            if (contact.getContactID().equals(cid)) {
                listOfContacts.remove(contact);
                return true;
            }
        }
        return false;
    }

    // Updates a contact's information by its ID
    public boolean updateContact(String cid, String fn, String ln, String pn, String addr) {
        for (Contact contact : listOfContacts) {
            if (contact.getContactID().equals(cid)) {
                if (fn != null && !fn.isEmpty() && fn.length() <= 10) {
                    contact.setFirstName(fn);
                }
                if (ln != null && !ln.isEmpty() && ln.length() <= 10) {
                    contact.setLastName(ln);
                }
                if (pn != null && !pn.isEmpty() && pn.length() <= 10) {
                    contact.setPhoneNumber(pn);
                }
                if (addr != null && !addr.isEmpty() && addr.length() <= 30) {
                    contact.setAddress(addr);
                }
                return true;
            }
        }
        return false;
    }

    // Retrieves a contact by its ID
    public Contact getContactById(String contactId) {
        if (contactId == null || contactId.isEmpty()) {
            throw new IllegalArgumentException("Contact ID cannot be null or empty");
        }
        for (Contact contact : listOfContacts) {
            if (contact.getContactID().equals(contactId)) {
                return contact;
            }
        }
        return null;
    }
}