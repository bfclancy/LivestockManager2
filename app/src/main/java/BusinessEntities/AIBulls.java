package BusinessEntities;

/**
 * Created by asus on 01/02/2016.
 */
public class AIBulls {

    private int id;
    private String code;
    private String name;
    private String breed;
    private float calvingdifficulty;
    private String availability;
    private float price;
    private String supplier;

    public AIBulls(int id, String code, String name, String breed, float calvingdifficulty, String availability, float price, String supplier) {
        this.setId(id);
        this.setCode(code);
        this.setName(name);
        this.setBreed(breed);
        this.setCalvingdifficulty(calvingdifficulty);
        this.setAvailability(availability);
        this.setPrice(price);
        this.setSupplier(supplier);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public float getCalvingdifficulty() {
        return calvingdifficulty;
    }

    public void setCalvingdifficulty(float calvingdifficulty) {
        this.calvingdifficulty = calvingdifficulty;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
}
