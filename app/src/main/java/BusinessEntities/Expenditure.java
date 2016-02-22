package BusinessEntities;

import java.util.Date;

/**
 * Created by asus on 10/10/2015.
 */
public class Expenditure {

    private int expenditureId;
    private Date expenditureDate;
    private double expenditureAmount;
    private String expenditureDescription;
    private String herdNumber;

    public Expenditure(int expenditureId, Date expenditureDate, double expenditureAmount, String expenditureDescription, String herdNumber) {
        this.setExpenditureId(expenditureId);
        this.setExpenditureDate(expenditureDate);
        this.setExpenditureAmount(expenditureAmount);
        this.setExpenditureDescription(expenditureDescription);
        this.setHerdNumber(herdNumber);
    }

    public int getExpenditureId() {
        return expenditureId;
    }

    public void setExpenditureId(int expenditureId) {
        this.expenditureId = expenditureId;
    }

    public Date getExpenditureDate() {
        return expenditureDate;
    }

    public void setExpenditureDate(Date expenditureDate) {
        this.expenditureDate = expenditureDate;
    }

    public double getExpenditureAmount() {
        return expenditureAmount;
    }

    public void setExpenditureAmount(double expenditureAmount) {
        this.expenditureAmount = expenditureAmount;
    }

    public String getExpenditureDescription() {
        return expenditureDescription;
    }

    public void setExpenditureDescription(String expenditureDescription) {
        this.expenditureDescription = expenditureDescription;
    }

    public String getHerdNumber() {
        return herdNumber;
    }

    public void setHerdNumber(String herdNumber) {
        this.herdNumber = herdNumber;
    }
}
