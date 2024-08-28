package com.curabook.models;

// Model class for appointment data
public class AppointmentData {
    private String facility;
    private String healthcareProgram;
    private String date;
    private String comment;
    private boolean booked;

    // Getters and setters for appointment data fields
    public String getFacility() {
        return facility;
    }

    public void setFacility(String facility) {
        this.facility = facility;
    }

    public String getHealthcareProgram() {
        return healthcareProgram;
    }

    public void setHealthcareProgram(String healthcareProgram) {
        this.healthcareProgram = healthcareProgram;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }
}
