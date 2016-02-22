package BusinessLogic;

import android.app.Activity;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus on 17/02/2016.
 */
public class Form {

    private List<Field> fields = new ArrayList<>();
    private Activity mActivity;

    public Form(Activity activity) {
        this.mActivity = activity;
    }

    public void addField(Field field) {
        fields.add(field);
    }

    public boolean isValid() {
        boolean result = true;
        try {
            for (Field field : fields) {
                result &= field.isValid();
            }
        } catch (FieldValidationException e) {
            result = false;

            EditText textView = e.getTextView();
            textView.requestFocus();
            textView.selectAll();

            FormUtils.showKeyboard(mActivity, textView);

            showErrorMessage(e.getMessage());
        }
        return result;
    }

    protected void showErrorMessage(String message) {
        // Crouton.makeText(mActivity, message, Style.ALERT).show();
        Toast.makeText(mActivity, message, Toast.LENGTH_LONG).show();
    }
}
