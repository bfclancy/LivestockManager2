package BusinessEntities;

/**
 * Created by asus on 9/30/2015.
 */
public class AnimalRemedy {

    private String remedyId;
    private String name;

    public AnimalRemedy(String remedyId, String name) {
        this.setRemedyId(remedyId);
        this.setName(name);
    }

    public String getRemedyId() {
        return remedyId;
    }

    public void setRemedyId(String remedyId) {
        this.remedyId = remedyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
