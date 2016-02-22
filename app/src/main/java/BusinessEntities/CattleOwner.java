package BusinessEntities;

/**
 * Created by asus on 01/02/2016.
 */
public class CattleOwner {

    private int idcattleowners;
    private String herdNumber;
    private String tagNumber;

    public CattleOwner(int idcattleowners, String herdNumber, String tagNumber) {
        this.setIdcattleowners(idcattleowners);
        this.setHerdNumber(herdNumber);
        this.setTagNumber(tagNumber);
    }

    public int getIdcattleowners() {
        return idcattleowners;
    }

    public void setIdcattleowners(int idcattleowners) {
        this.idcattleowners = idcattleowners;
    }

    public String getHerdNumber() {
        return herdNumber;
    }

    public void setHerdNumber(String herdNumber) {
        this.herdNumber = herdNumber;
    }

    public String getTagNumber() {
        return tagNumber;
    }

    public void setTagNumber(String tagNumber) {
        this.tagNumber = tagNumber;
    }
}
