package BusinessLogic;

import android.content.Context;

/**
 * Created by asus on 17/02/2016.
 */
abstract class BaseValidation implements Validation {

    protected Context mContext;

    protected BaseValidation(Context context) {
        mContext = context;
    }

}
