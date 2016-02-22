package BusinessEntities;

import java.util.Date;

/**
 * Created by asus on 9/30/2015.
 */
public class TestResults {

    private int testId;
    private String tagNumber;
    private String testType;
    private String result;
    private Date testDate;

    public TestResults(int testId, String tagNumber, String testType, String result, Date testDate) {
        this.setTestId(testId);
        this.setTagNumber(tagNumber);
        this.setTestType(testType);
        this.setResult(result);
        this.setTestDate(testDate);
    }

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public String getTagNumber() {
        return tagNumber;
    }

    public void setTagNumber(String tagNumber) {
        this.tagNumber = tagNumber;
    }

    public String getTestType() {
        return testType;
    }

    public void setTestType(String testType) {
        this.testType = testType;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Date getTestDate() {
        return testDate;
    }

    public void setTestDate(Date testDate) {
        this.testDate = testDate;
    }
}
