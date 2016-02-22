package BusinessLogic;

import android.widget.EditText;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by asus on 17/02/2016.
 */
public class Field {

    private List<Validation> mValidations = new LinkedList<>();
    private EditText mTextView;

    private Field(EditText textView) {
        this.mTextView = textView;
    }

    public static Field using(EditText textView) {
        return new Field(textView);
    }

    public Field validate(Validation what) {
        mValidations.add(what);
        return this;
    }

    public EditText getTextView() {
        return mTextView;
    }

    public boolean isValid() throws FieldValidationException {
        for (Validation validation : mValidations) {
            if (!validation.isValid(mTextView.getText().toString())) {
                String errorMessage = validation.getErrorMessage();
                throw new FieldValidationException(errorMessage, mTextView);
            }
        }
        return true;
    }
}
