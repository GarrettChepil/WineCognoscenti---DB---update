package dreamlinedesign.winecognoscenti.adapters;

/**
 * Created by GeEEE on 2016-02-01.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import dreamlinedesign.winecognoscenti.R;

public class WineListAdapter extends ArrayAdapter<String> {
    private Context context;

    String [] list;
    public WineListAdapter(Context context, int textViewResourceId, String [] list) {
        super(context, -1, list);
        this.context = context;

        this.list = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.winlist, parent, false);
        TextView textView = (TextView) convertView.findViewById(R.id.customListtxt);
        textView.setText(list[position]);
        // change the icon for Windows and iPhone


        return convertView;
    }

    @Override
    public long getItemId(int position ) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

}





