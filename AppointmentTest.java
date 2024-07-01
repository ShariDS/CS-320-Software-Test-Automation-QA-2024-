package Tests;

/*
 * The 'AppointmentTest' class contains unit tests for the 'Appointment' class.
 * Primary functions are constructor testing, getter method testing, setter method testing, and edge case handling.
 */


//import java.util.*;
import org.junit.jupiter.api.Test;
import Milestone1.Appointment;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;

public class AppointmentTest {

    @Test
    public void testAppointmentCreation() {
        // Test creating a valid appointment
        Date futureDate = new Date(System.currentTimeMillis() + 86400000); // 1 day in the future
        Appointment appointment = new Appointment("1234567890", futureDate, "Doctor's appointment");
        assertEquals("1234567890", appointment.getAppointmentID());
        assertEquals(futureDate, appointment.getAppointmentDate());
        assertEquals("Doctor's appointment", appointment.getDescription());
    }

    @Test
    public void testInvalidAppointmentID() {
        // Test creating an appointment with an invalid ID
        Date futureDate = new Date(System.currentTimeMillis() + 86400000);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345678901", futureDate, "Doctor's appointment");
        });
        assertEquals("Invalid appointment id - null or length > 10", exception.getMessage());
    }

    @Test
    public void testInvalidAppointmentDate() {
        // Test creating an appointment with an invalid date
        Date pastDate = new Date(System.currentTimeMillis() - 86400000); // 1 day in the past
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1234567890", pastDate, "Doctor's appointment");
        });
        assertEquals("Invalid appointment date - past date", exception.getMessage());
    }

    @Test
    public void testInvalidDescription() {
        // Test creating an appointment with an invalid description
        Date futureDate = new Date(System.currentTimeMillis() + 86400000);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1234567890", futureDate, "This description is way too long and exceeds the fifty character limit.");
        });
        assertEquals("Invalid description - null or length > 50", exception.getMessage());
    }

    @Test
    public void testSetters() {
        // Test setting valid values
        Date futureDate = new Date(System.currentTimeMillis() + 86400000);
        Appointment appointment = new Appointment("1234567890", futureDate, "Doctor's appointment");

        Date newFutureDate = new Date(System.currentTimeMillis() + 172800000); // 2 days in the future
        appointment.setAppointmentDate(newFutureDate);
        assertEquals(newFutureDate, appointment.getAppointmentDate());

        appointment.setDescription("New Description");
        assertEquals("New Description", appointment.getDescription());
    }

    @Test
    public void testInvalidSetters() {
        // Test setting invalid values
        Date futureDate = new Date(System.currentTimeMillis() + 86400000);
        Appointment appointment = new Appointment("1234567890", futureDate, "Doctor's appointment");

        Date pastDate = new Date(System.currentTimeMillis() - 86400000);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            appointment.setAppointmentDate(pastDate);
        });
        assertEquals("Invalid appointment date - past date", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            appointment.setDescription("This description is way too long and exceeds the fifty character limit.");
        });
        assertEquals("Invalid description - null or length > 50", exception.getMessage());
    }
}