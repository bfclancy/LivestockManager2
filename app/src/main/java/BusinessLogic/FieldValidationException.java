package BusinessLogic;

import android.widget.EditText;

/**
 * Created by asus on 17/02/2016.
 */
public class FieldValidationException extends Exception{

    private EditText mTextView;

    public FieldValidationException(String message, EditText textView) {
        super(message);
        mTextView = textView;
    }

    public EditText getTextView() {
        return mTextView;
    }
}
