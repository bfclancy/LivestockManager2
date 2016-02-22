package BusinessEntities;

import java.util.Date;

/**
 * Created by asus on 01/02/2016.
 */
public class Pregnancy {

    private int id;
    private String damTagNumber;
    private Date date;
    private Date dueDate;

    public Pregnancy(int id, String damTagNumber, Date date, Date dueDate) {
        this.setId(id);
        this.setDamTagNumber(damTagNumber);
        this.setDate(date);
        this.setDueDate(dueDate);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDamTagNumber() {
        return damTagNumber;
    }

    public void setDamTagNumber(String damTagNumber) {
        this.damTagNumber = damTagNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
}
