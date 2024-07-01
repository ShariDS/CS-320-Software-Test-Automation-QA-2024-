package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import Milestone1.Contact;
import Milestone1.ContactService;

public class ContactServiceTest {

    @Test
    public void testAddContact() {
        // Test adding a contact
        ContactService service = new ContactService();
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        assertTrue(service.addContact(contact));
    }

    @Test
    public void testAddDuplicateContact() {
        // Test adding a duplicate contact
        ContactService service = new ContactService();
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        assertFalse(service.addContact(contact));
    }

    @Test
    public void testDeleteContact() {
        // Test deleting a contact
        ContactService service = new ContactService();
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        assertTrue(service.deleteContact("1234567890"));
        assertFalse(service.deleteContact("nonexistent"));
    }

    @Test
    public void testUpdateContact() {
        // Test updating a contact
        ContactService service = new ContactService();
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        assertTrue(service.updateContact("1234567890", "Jane", "Smith", "0987654321", "456 Elm St"));
        assertEquals("Jane", contact.getFirstName());
        assertEquals("Smith", contact.getLastName());
        assertEquals("0987654321", contact.getPhoneNumber());
        assertEquals("456 Elm St", contact.getAddress());
    }

    @Test
    public void testUpdateNonexistentContact() {
        // Test updating a contact that does not exist
        ContactService service = new ContactService();
        assertFalse(service.updateContact("nonexistent", "Jane", "Smith", "0987654321", "456 Elm St"));
    }

    @Test
    public void testGetContactById() {
        // Test retrieving a contact by its ID
        ContactService service = new ContactService();
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        Contact retrievedContact = service.getContactById("1234567890");
        assertNotNull(retrievedContact);
        assertEquals("John", retrievedContact.getFirstName());
    }

    @Test
    public void testGetContactByIdNotFound() {
        // Test retrieving a contact that does not exist
        ContactService service = new ContactService();
        assertNull(service.getContactById("nonexistent"));
    }
}