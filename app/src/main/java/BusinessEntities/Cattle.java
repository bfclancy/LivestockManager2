package BusinessEntities;


import java.util.Date;

/**
 * Created by asus on 9/30/2015.
 */
public class Cattle {

    private String tagNumber;
    private String gender;
    private Date dateOfBirth;
    private Date dateLastTBTest;
    private Date dateMovedIn;
    private String sire;
    private String sireBreed;
    private String damTagNumber;

    public Cattle(String tagNumber, String gender, Date dateOfBirth, Date dateLastTBTest, Date dateMovedIn, String sire, String sireBreed, String damTagNumber) {
        this.tagNumber = tagNumber;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.dateLastTBTest = dateLastTBTest;
        this.dateMovedIn = dateMovedIn;
        this.sire = sire;
        this.sireBreed = sireBreed;
        this.damTagNumber = damTagNumber;
    }

    public Cattle(){

    }
    public String getTagNumber() {
        return tagNumber;
    }

    public void setTagNumber(String tagNumber) {
        this.tagNumber = tagNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getDateLastTBTest() {
        return dateLastTBTest;
    }

    public void setDateLastTBTest(Date dateLastTBTest) {
        this.dateLastTBTest = dateLastTBTest;
    }


    public Date getDateMovedIn() {
        return dateMovedIn;
    }

    public void setDateMovedIn(Date dateMovedIn) {
        this.dateMovedIn = dateMovedIn;
    }

    public String getSire() {
        return sire;
    }

    public void setSire(String sire) {
        this.sire = sire;
    }

    public String getSireBreed() {
        return sireBreed;
    }

    public void setSireBreed(String sireBreed) {
        this.sireBreed = sireBreed;
    }

    public String getDamTagNumber() {
        return damTagNumber;
    }

    public void setDamTagNumber(String damTagNumber) {
        this.damTagNumber = damTagNumber;
    }
}
