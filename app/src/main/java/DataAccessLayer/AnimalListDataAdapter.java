package DataAccessLayer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.asus.livestockmanager.R;

import java.util.ArrayList;

import BusinessEntities.Cattle;
import BusinessEntities.DateFormatter;

/**
 * Created by asus on 10/3/2015.
 */
public class AnimalListDataAdapter extends ArrayAdapter {

    private ArrayList<Object> list = new ArrayList<Object>();
    public AnimalListDataAdapter(Context context, int resource) {
        super(context, resource);
    }

    static class LayoutHandler
    {
        TextView tagNumber, breed, gender, dob, tb, br, movedIn, pp, sp, weight;
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
            row = layoutInflater.inflate(R.layout.list_view_animal_details, parent, false);
            layoutHandler = new LayoutHandler();
            layoutHandler.tagNumber = (TextView) row.findViewById(R.id.textDisplayTagNumber);
            layoutHandler.breed = (TextView) row.findViewById(R.id.textDisplayBreed);
            layoutHandler.gender = (TextView) row.findViewById(R.id.textDisplayGender);
            layoutHandler.dob = (TextView) row.findViewById(R.id.textDisplayDOB);
            layoutHandler.tb = (TextView) row.findViewById(R.id.textDisplayTB);
            layoutHandler.br = (TextView) row.findViewById(R.id.textDisplayBR);
            layoutHandler.movedIn = (TextView) row.findViewById(R.id.textDisplayDateMoved);
            layoutHandler.pp = (TextView) row.findViewById(R.id.textDisplayPP);
            layoutHandler.sp = (TextView) row.findViewById(R.id.textDisplaySP);
            layoutHandler.weight = (TextView) row.findViewById(R.id.textDisplayWeight);
            row.setTag(layoutHandler);
        }
        else {
            layoutHandler = (LayoutHandler) row.getTag();

        }

        Cattle cattle = (Cattle) this.getItem(position);
        layoutHandler.tagNumber.setText(cattle.getTagNumber());
        layoutHandler.gender.setText(cattle.getGender());
        layoutHandler.dob.setText(cattle.getDateOfBirth().toString());
        layoutHandler.tb.setText(DateFormatter.formatForDisplay(cattle.getDateLastTBTest().toString()));
        layoutHandler.movedIn.setText(cattle.getDateMovedIn().toString());
        layoutHandler.pp.setText(String.valueOf(cattle.getDamTagNumber()));
        layoutHandler.sp.setText(String.valueOf(cattle.getSire()));
        layoutHandler.weight.setText(String.valueOf(cattle.getSireBreed()));
        return row;
    }
}
