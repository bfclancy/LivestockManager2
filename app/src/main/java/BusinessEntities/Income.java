package BusinessEntities;

import java.util.Date;

/**
 * Created by asus on 10/10/2015.
 */
public class Income {

    private int incomeId;
    private Date incomeDate;
    private double incomeAmount;
    private String incomeDescription;
    private String herdNumber;

    public Income(int incomeId, Date incomeDate, double incomeAmount, String incomeDescription, String herdNumber) {
        this.setIncomeId(incomeId);
        this.setIncomeDate(incomeDate);
        this.setIncomeAmount(incomeAmount);
        this.setIncomeDescription(incomeDescription);
        this.setHerdNumber(herdNumber);
    }

    public int getIncomeId() {
        return incomeId;
    }

    public void setIncomeId(int incomeId) {
        this.incomeId = incomeId;
    }

    public Date getIncomeDate() {
        return incomeDate;
    }

    public void setIncomeDate(Date incomeDate) {
        this.incomeDate = incomeDate;
    }

    public double getIncomeAmount() {
        return incomeAmount;
    }

    public void setIncomeAmount(double incomeAmount) {
        this.incomeAmount = incomeAmount;
    }

    public String getIncomeDescription() {
        return incomeDescription;
    }

    public void setIncomeDescription(String incomeDescription) {
        this.incomeDescription = incomeDescription;
    }

    public String getHerdNumber() {
        return herdNumber;
    }

    public void setHerdNumber(String herdNumber) {
        this.herdNumber = herdNumber;
    }
}
