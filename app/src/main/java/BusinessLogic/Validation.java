package BusinessLogic;

/**
 * Created by asus on 17/02/2016.
 */
public interface Validation {

    String getErrorMessage();

    boolean isValid(String text);

}
