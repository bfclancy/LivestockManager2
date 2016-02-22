package BusinessEntities;

import java.sql.Date;

/**
 * Created by asus on 01/02/2016.
 */
public class remedyadministration {

    private int id;
    private int quantity;
    private String nameofremedy;
    private Date dateacquired;
    private String supplier;
    private Date dateofadministering;
    private int quantityadministered;
    private String tagNumber;
    private String personAdministering;
    private Date withdrawalPeriodExpiration;
    private String prescribingVeterinaryPractitioner;
    private int quantityunusedorexpired;


    public remedyadministration(int id, int quantity, String nameofremedy, Date dateacquired, String supplier, Date dateofadministering, int quantityadministered, String tagNumber,
                                String personAdministering, Date withdrawalPeriodExpiration, String prescribingVeterinaryPractitioner, int quantityunusedorexpired) {
        this.setId(id);
        this.setQuantity(quantity);
        this.setNameofremedy(nameofremedy);
        this.setDateacquired(dateacquired);
        this.setSupplier(supplier);
        this.setDateofadministering(dateofadministering);
        this.setQuantityadministered(quantityadministered);
        this.setTagNumber(tagNumber);
        this.setPersonAdministering(personAdministering);
        this.setWithdrawalPeriodExpiration(withdrawalPeriodExpiration);
        this.setPrescribingVeterinaryPractitioner(prescribingVeterinaryPractitioner);
        this.setQuantityunusedorexpired(quantityunusedorexpired);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getNameofremedy() {
        return nameofremedy;
    }

    public void setNameofremedy(String nameofremedy) {
        this.nameofremedy = nameofremedy;
    }

    public Date getDateacquired() {
        return dateacquired;
    }

    public void setDateacquired(Date dateacquired) {
        this.dateacquired = dateacquired;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public Date getDateofadministering() {
        return dateofadministering;
    }

    public void setDateofadministering(Date dateofadministering) {
        this.dateofadministering = dateofadministering;
    }

    public int getQuantityadministered() {
        return quantityadministered;
    }

    public void setQuantityadministered(int quantityadministered) {
        this.quantityadministered = quantityadministered;
    }

    public String getTagNumber() {
        return tagNumber;
    }

    public void setTagNumber(String tagNumber) {
        this.tagNumber = tagNumber;
    }

    public String getPersonAdministering() {
        return personAdministering;
    }

    public void setPersonAdministering(String personAdministering) {
        this.personAdministering = personAdministering;
    }

    public Date getWithdrawalPeriodExpiration() {
        return withdrawalPeriodExpiration;
    }

    public void setWithdrawalPeriodExpiration(Date withdrawalPeriodExpiration) {
        this.withdrawalPeriodExpiration = withdrawalPeriodExpiration;
    }

    public String getPrescribingVeterinaryPractitioner() {
        return prescribingVeterinaryPractitioner;
    }

    public void setPrescribingVeterinaryPractitioner(String prescribingVeterinaryPractitioner) {
        this.prescribingVeterinaryPractitioner = prescribingVeterinaryPractitioner;
    }

    public int getQuantityunusedorexpired() {
        return quantityunusedorexpired;
    }

    public void setQuantityunusedorexpired(int quantityunusedorexpired) {
        this.quantityunusedorexpired = quantityunusedorexpired;
    }
}
