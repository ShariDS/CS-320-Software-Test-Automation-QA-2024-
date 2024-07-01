package Tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import Milestone1.Contact;

public class ContactTest {

    @Test
    public void testContactCreation() {
        // Test creating a valid contact
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        assertEquals("1234567890", contact.getContactID());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhoneNumber());
        assertEquals("123 Main St", contact.getAddress());
    }

    @Test
    public void testInvalidContactID() {
        // Test creating a contact with an invalid ID
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St");
        });
        assertEquals("Invalid contact ID - null or length > 10", exception.getMessage());
    }

    @Test
    public void testInvalidFirstName() {
        // Test creating a contact with an invalid first name
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "Johnathon", "Doe", "1234567890", "123 Main St");
        });
        assertEquals("Invalid first name - null or length > 10", exception.getMessage());
    }

    @Test
    public void testInvalidLastName() {
        // Test creating a contact with an invalid last name
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "John", "DoeLastNameIsTooLong", "1234567890", "123 Main St");
        });
        assertEquals("Invalid last name - null or length > 10", exception.getMessage());
    }

    @Test
    public void testInvalidPhoneNumber() {
        // Test creating a contact with an invalid phone number
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "John", "Doe", "12345678901", "123 Main St");
        });
        assertEquals("Invalid phone number - null or length > 10", exception.getMessage());
    }

    @Test
    public void testInvalidAddress() {
        // Test creating a contact with an invalid address
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "John", "Doe", "1234567890", "This address is way too long and exceeds the thirty character limit.");
        });
        assertEquals("Invalid address - null or length > 30", exception.getMessage());
    }

    @Test
    public void testSetters() {
        // Test setting valid values
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contact.setFirstName("Jane");
        assertEquals("Jane", contact.getFirstName());
        contact.setLastName("Smith");
        assertEquals("Smith", contact.getLastName());
        contact.setPhoneNumber("0987654321");
        assertEquals("0987654321", contact.getPhoneNumber());
        contact.setAddress("456 Elm St");
        assertEquals("456 Elm St", contact.getAddress());
    }

    @Test
    public void testInvalidSetters() {
        // Test setting invalid values
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName("Johnathon");
        });
        assertEquals("Invalid first name - null or length > 10", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName("DoeLastNameIsTooLong");
        });
        assertEquals("Invalid last name - null or length > 10", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhoneNumber("12345678901");
        });
        assertEquals("Invalid phone number - null or length > 10", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress("This address is way too long and exceeds the thirty character limit.");
        });
        assertEquals("Invalid address - null or length > 30", exception.getMessage());
    }
}