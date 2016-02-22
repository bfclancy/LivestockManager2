package BusinessEntities;

/**
 * Created by asus on 9/30/2015.
 */
public class Veterinarian {

    private String veterinarianName;
    private String veterinarianAddress;
    private String phoneNumber;
    private int id;

    public Veterinarian(String phoneNumber, String veterinarianAddress, String veterinarianName) {
        this.phoneNumber = phoneNumber;
        this.veterinarianAddress = veterinarianAddress;
        this.veterinarianName = veterinarianName;
    }

    public Veterinarian(int id, String veterinarianName, String veterinarianAddress, String phoneNumber) {
        this.veterinarianName = veterinarianName;
        this.veterinarianAddress = veterinarianAddress;
        this.phoneNumber = phoneNumber;
        this.id = id;
    }

    public String getVeterinarianName() {
        return veterinarianName;
    }

    public void setVeterinarianName(String veterinarianName) {
        this.veterinarianName = veterinarianName;
    }

    public String getVeterinarianAddress() {
        return veterinarianAddress;
    }

    public void setVeterinarianAddress(String veterinarianAddress) {
        this.veterinarianAddress = veterinarianAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
