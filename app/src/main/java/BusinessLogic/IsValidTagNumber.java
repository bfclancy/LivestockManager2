package BusinessLogic;

import android.content.Context;

import com.example.asus.livestockmanager.R;

/**
 * Created by asus on 17/02/2016.
 */
public class IsValidTagNumber extends BaseValidation {

    private static final String TAG_NUMBER_PATTERN = "^IE";

    private IsValidTagNumber(Context context) {
        super(context);
    }

    public static Validation build(Context context) {
        return new IsValidTagNumber(context);
    }

    @Override
    public String getErrorMessage() {
        return mContext.getString(R.string.zvalidations_not_tag_number);
    }

    @Override
    public boolean isValid(String text) {
        return text.matches(TAG_NUMBER_PATTERN);
    }
}
