package Milestone1;

import java.util.Date;

/**
 * The Appointment class represents an individual appointment with a unique ID, date, and description.
 * The appointment details are validated for correctness.
 */
public class Appointment {
    private final String appointmentId; // Limit 10 characters
    private Date appointmentDate; // Must be >= current date
    private String description; // Limit 50 characters

    /**
     * Constructs an Appointment object with the given ID, date, and description.
     * @param aid the unique ID of the appointment, must be non-null and <= 10 characters
     * @param d the date of the appointment, must be non-null and not in the past
     * @param descript the description of the appointment, must be non-null and <= 50 characters
     */
    public Appointment(String aid, Date d, String descript) {
        Date today = new Date();
        if (aid == null || aid.length() > 10) {
            throw new IllegalArgumentException("Invalid appointment id - null or length > 10");
        }
        if (d == null) {
            throw new IllegalArgumentException("Invalid appointment date - null");
        } else if (d.before(today)) {
            throw new IllegalArgumentException("Invalid appointment date - past date");
        }
        if (descript == null || descript.length() > 50) {
            throw new IllegalArgumentException("Invalid description - null or length > 50");
        }
        this.appointmentId = aid;
        this.appointmentDate = d;
        this.description = descript;
    }

    // Getters
    public String getAppointmentID() {
        return appointmentId;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public String getDescription() {
        return description;
    }

    // Setters
    public void setAppointmentDate(Date d) {
        Date today = new Date();
        if (d == null) {
            throw new IllegalArgumentException("Invalid appointment date - null");
        } else if (d.before(today)) {
            throw new IllegalArgumentException("Invalid appointment date - past date");
        }
        this.appointmentDate = d;
    }

    public void setDescription(String descript) {
        if (descript == null || descript.length() > 50) {
            throw new IllegalArgumentException("Invalid description - null or length > 50");
        }
        this.description = descript;
    }
}