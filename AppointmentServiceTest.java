package Tests;

/*
 * The 'AppointmentServiceTest' class contains unit tests for the 'AppointmentService' class. 
 * Primary functions include adding appointments, deleting appointments, unique ID verification, and list management.
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import Milestone1.Appointment;
import Milestone1.AppointmentService;
import java.util.Date;
import java.util.List;

public class AppointmentServiceTest {

    @Test
    public void testAddAppointment() {
        // Test adding an appointment
        AppointmentService service = new AppointmentService();
        Date futureDate = new Date(System.currentTimeMillis() + 86400000); // 1 day in the future
        service.addAppointment(futureDate, "Doctor's appointment");
        assertEquals(1, service.getAppointmentList().size());
    }

    @Test
    public void testDeleteAppointment() throws Exception {
        // Test deleting an appointment
        AppointmentService service = new AppointmentService();
        Date futureDate = new Date(System.currentTimeMillis() + 86400000);
        service.addAppointment(futureDate, "Doctor's appointment");
        Appointment appt = service.getAppointmentList().get(0);
        service.deleteAppointment(appt.getAppointmentID());
        assertEquals(0, service.getAppointmentList().size());
    }

    @Test
    public void testSearchForAppointment() throws Exception {
        // Test searching for an appointment
        AppointmentService service = new AppointmentService();
        Date futureDate = new Date(System.currentTimeMillis() + 86400000);
        service.addAppointment(futureDate, "Doctor's appointment");
        Appointment appt = service.getAppointmentList().get(0);
        Appointment foundAppt = service.searchForAppointment(appt.getAppointmentID());
        assertEquals(appt, foundAppt);
    }

    @Test
    public void testSearchForAppointmentNotFound() {
        // Test searching for an appointment that does not exist
        AppointmentService service = new AppointmentService();
        Exception exception = assertThrows(Exception.class, () -> {
            service.searchForAppointment("nonexistent");
        });
        assertEquals("The appointment does not exist!", exception.getMessage());
    }

    @Test
    public void testGetAppointmentList() {
        // Test getting the list of appointments
        AppointmentService service = new AppointmentService();
        Date futureDate = new Date(System.currentTimeMillis() + 86400000);
        service.addAppointment(futureDate, "Doctor's appointment");
        List<Appointment> appointments = service.getAppointmentList();
        assertEquals(1, appointments.size());
    }
}