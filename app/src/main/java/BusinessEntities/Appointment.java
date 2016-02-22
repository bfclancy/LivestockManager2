package BusinessEntities;

import java.util.Date;

/**
 * Created by asus on 10/6/2015.
 */
public class Appointment {

    private int appointmentId;
    private String type;
    private Date time;
    private Date date;
    private String herdNumber;


    public Appointment(int appointmentId, String type, Date time, Date date, String herdNumber) {
        this.setAppointmentId(appointmentId);
        this.setType(type);
        this.setTime(time);
        this.setDate(date);
        this.setHerdNumber(herdNumber);
    }

    public Appointment(String type, Date time, Date date) {
        this.setType(type);
        this.setTime(time);
        this.setDate(date);
    }

    public Appointment(int id, String type, Date time, Date date) {
        this.setAppointmentId(id);
        this.setType(type);
        this.setTime(time);
        this.setDate(date);
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getHerdNumber() {
        return herdNumber;
    }

    public void setHerdNumber(String herdNumber) {
        this.herdNumber = herdNumber;
    }
}

