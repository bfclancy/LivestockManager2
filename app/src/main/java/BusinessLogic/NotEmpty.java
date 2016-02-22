package BusinessLogic;

import android.content.Context;
import android.text.TextUtils;

import com.example.asus.livestockmanager.R;

/**
 * Created by asus on 17/02/2016.
 */
public class NotEmpty extends BaseValidation {

    public static Validation build(Context context) {
        return new NotEmpty(context);
    }

    private NotEmpty(Context context) {
        super(context);
    }

    @Override
    public String getErrorMessage() {
        return mContext.getString(R.string.zvalidations_empty);
    }

    @Override
    public boolean isValid(String text) {
        return !TextUtils.isEmpty(text);
    }
}
