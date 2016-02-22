package DataAccessLayer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.asus.livestockmanager.R;

import java.util.List;

import BusinessEntities.Cattle;

/**
 * Created by asus on 04/02/2016.
 */
public class TestListAdapter extends BaseAdapter {

    private List<Cattle> cattle;
    private Context context;
    private int numItems = 0;

    public TestListAdapter(final List<Cattle> cattle, Context context) {
        this.cattle = cattle;
    }

    public int getCount() {
        return numItems;
    }

    public Cattle getItem(int position) {
        return cattle.get(position);
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        // Get the current list item
        final Cattle c = cattle.get(position);
        // Get the layout for the list item
        final RelativeLayout itemLayout = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.test_result_layout, parent, false);

        // Set the text label as defined in our list item
        TextView txtLabel = (TextView) itemLayout.findViewById(R.id.textViewTestTagNumber);
        txtLabel.setText(c.getTagNumber());

        return itemLayout;
    }
}
