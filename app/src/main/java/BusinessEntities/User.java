package BusinessEntities;

/**
 * Created by asus on 9/30/2015.
 */
public class User {

    private String firstName;
    private String surname;
    private String address;
    private String county;
    private String herdNumber;
    private String PAC;
    private String userName;
    private String email;
    private String password;

    public User(String firstName, String surname, String address, String county, String herdNumber, String PAC, String userName, String email, String password) {
        this.setFirstName(firstName);
        this.setSurname(surname);
        this.setAddress(address);
        this.setCounty(county);
        this.setHerdNumber(herdNumber);
        this.setPAC(PAC);
        this.setUserName(userName);
        this.setEmail(email);
        this.setPassword(password);
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

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getHerdNumber() {
        return herdNumber;
    }

    public void setHerdNumber(String herdNumber) {
        this.herdNumber = herdNumber;
    }

    public String getPAC() {
        return PAC;
    }

    public void setPAC(String PAC) {
        this.PAC = PAC;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
