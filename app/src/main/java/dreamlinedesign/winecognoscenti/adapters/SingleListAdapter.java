package dreamlinedesign.winecognoscenti.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import dreamlinedesign.winecognoscenti.R;


public class SingleListAdapter extends ArrayAdapter {
    String objects[];
    Context context;
    TextView customtext;
    View myView;

    public SingleListAdapter(Context context, int textViewResourceId, String[] objects) {
        super(context, textViewResourceId, objects);
        this.objects = objects;
        this.context = context;
    }

    public View getCustomView(int position, ViewGroup parent) {

// Inflating the layout for the custom Spinner
        View convertView = LayoutInflater.from(context).inflate(R.layout.single_custom_list, parent, false);

// Declaring and Typecasting the textview in the inflated layout
        TextView customText = (TextView) convertView.findViewById(R.id.customText);

// Setting the text using the array
        customText.setText(objects[position]);

// Setting the color of the text
        customText.setTextColor(Color.BLACK);
        customText.setTextSize(20f);



        return convertView;
    }

    // It gets a View that displays in the drop down popup the data at the specified position
    @Override
    public View getDropDownView(int position, View convertView,
                                ViewGroup parent) {
        return getCustomView(position, parent);
    }

    // It gets a View that displays the data at the specified position
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, parent);
    }
}
