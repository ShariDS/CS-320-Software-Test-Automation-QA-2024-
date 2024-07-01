package Milestone1;

import java.util.*;

/**
 * The AppointmentService class manages a collection of Appointment objects.
 * Primary functions include adding, deleting, searching for appointments, and list management.
 */
public class AppointmentService {
    private final List<Appointment> listOfAppointments = new ArrayList<>();

    // Generates a new unique ID for an appointment
    private String newUniqueId() {
        return UUID.randomUUID().toString().substring(0, 10);
    }

    // Adds a new appointment with the given date and description
    public void addAppointment(Date date, String description) {
        Appointment appt = new Appointment(newUniqueId(), date, description);
        listOfAppointments.add(appt);
    }

    // Deletes an appointment by its ID
    public void deleteAppointment(String id) throws Exception {
        listOfAppointments.remove(searchForAppointment(id));
    }

    // Gets the list of all appointments
    public List<Appointment> getAppointmentList() {
        return listOfAppointments;
    }

    // Searches for an appointment by its ID
    public Appointment searchForAppointment(String id) throws Exception {
        for (Appointment appointment : listOfAppointments) {
            if (id.equals(appointment.getAppointmentID())) {
                return appointment;
            }
        }
        throw new Exception("The appointment does not exist!");
    }
}