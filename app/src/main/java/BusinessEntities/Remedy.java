package BusinessEntities;

/**
 * Created by asus on 13/02/2016.
 */
public class Remedy {

    private int id;
    private String name;
    private String productNumber;
    private String productGroup;

    public Remedy(String name, String productNumber, String productGroup) {
        this.setName(name);
        this.setProductNumber(productNumber);
        this.setProductGroup(productGroup);
    }

    public Remedy(int id, String name, String productNumber, String productGroup) {
        this.setId(id);
        this.setName(name);
        this.setProductNumber(productNumber);
        this.setProductGroup(productGroup);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public String getProductGroup() {
        return productGroup;
    }

    public void setProductGroup(String productGroup) {
        this.productGroup = productGroup;
    }
}
