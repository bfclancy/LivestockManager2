package BusinessLogic;

import android.content.Context;

import com.example.asus.livestockmanager.R;

/**
 * Created by asus on 17/02/2016.
 */
public class IsValidPassword extends BaseValidation {

    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";

    private IsValidPassword(Context context) {
        super(context);
    }

    public static Validation build(Context context) {
        return new IsValidPassword(context);
    }

    @Override
    public String getErrorMessage() {
        return mContext.getString(R.string.zvalidations_not_password);
    }

    @Override
    public boolean isValid(String text) {
        return text.matches(PASSWORD_PATTERN);
    }
}
