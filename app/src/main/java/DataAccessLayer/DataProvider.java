package DataAccessLayer;

/**
 * Created by asus on 9/29/2015.
 */
public class DataProvider {

    private String firstName;
    private String surname;
    private String address;
    private String herdNumber;
    private String password;
    private String userName;
    private String PAC;

    public DataProvider(String firstName, String surname, String address, String herdNumber, String password, String userName, String PAC) {
        this.firstName = firstName;
        this.surname = surname;
        this.address = address;
        this.herdNumber = herdNumber;
        this.password = password;
        this.userName = userName;
        this.PAC = PAC;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHerdNumber() {
        return herdNumber;
    }

    public void setHerdNumber(String herdNumber) {
        this.herdNumber = herdNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPAC() {
        return PAC;
    }

    public void setPAC(String PAC) {
        this.PAC = PAC;
    }
}
