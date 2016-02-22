package DataAccessLayer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.asus.livestockmanager.R;

import java.util.ArrayList;

/**
 * Created by asus on 9/29/2015.
 */
public class ListDataAdapter extends ArrayAdapter{

    private ArrayList<Object> list = new ArrayList<Object>();
    public ListDataAdapter(Context context, int resource) {
        super(context, resource);
    }

    static class LayoutHandler
    {
        TextView firstName, surname, address, herdNumber, userName, PAC, password;
    }
    @Override
    public void add(Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        LayoutHandler layoutHandler;
        if(row == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.list_view_user_details_layout, parent, false);
            layoutHandler = new LayoutHandler();
            layoutHandler.firstName = (TextView) row.findViewById(R.id.textDisplayFirstName);
            layoutHandler.surname = (TextView) row.findViewById(R.id.textDisplaySurname);
            layoutHandler.address = (TextView) row.findViewById(R.id.textDisplayAddress);
            layoutHandler.herdNumber = (TextView) row.findViewById(R.id.textDisplayHerdNumber);
            layoutHandler.userName = (TextView) row.findViewById(R.id.textDisplayUserName);
            layoutHandler.PAC = (TextView) row.findViewById(R.id.textDisplayPAC);
            layoutHandler.password = (TextView) row.findViewById(R.id.textDisplayPassword);
            row.setTag(layoutHandler);
        }
        else {
            layoutHandler = (LayoutHandler) row.getTag();

        }

        DataProvider dataProvider = (DataProvider) this.getItem(position);
        layoutHandler.firstName.setText(dataProvider.getFirstName());
        layoutHandler.surname.setText(dataProvider.getSurname());
        layoutHandler.address.setText(dataProvider.getAddress());
        layoutHandler.herdNumber.setText(dataProvider.getHerdNumber());
        layoutHandler.userName.setText(dataProvider.getUserName());
        layoutHandler.PAC.setText(dataProvider.getPAC());
        layoutHandler.password.setText(dataProvider.getPassword());
        return row;
    }
}
