package dreamlinedesign.winecognoscenti.adapters;

/**
 * Created by GeEEE on 2016-02-04.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

import dreamlinedesign.winecognoscenti.R;

public class DropDownListAdapter extends BaseAdapter {

    private ArrayList<String> mListItems, sub;
    private LayoutInflater mInflater;
    private TextView mSelectedItems;
    private  int selectedCount = 0;
    private  String firstSelected = "";
    private ViewHolder holder;
    private  String selected = "";	//shortened selected values representation
    public Boolean[] checkSelected;
    public DropDownCheckBox dropDownCheckBox;
    public  String getSelected() {
        return selected;
    }
    private String origtxt;


    public void setSelected(String selected) {

        this.selected = selected;
    }

    public DropDownListAdapter(Context context, ArrayList<String> items, ArrayList<String> sub,
                               TextView tv, Boolean [] checkSelected, DropDownCheckBox dropDownCheckBox) {
        mListItems = new ArrayList<String>();
        mListItems.addAll(items);
        this.sub = new ArrayList<>();
        this.sub.addAll(sub);
        mInflater = LayoutInflater.from(context);
        mSelectedItems = tv;
        this.checkSelected = checkSelected;
        this.dropDownCheckBox = dropDownCheckBox;
        origtxt = tv.getText().toString();

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return mListItems.size();
    }

    @Override
    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.drop_down_list_row, null);
            holder = new ViewHolder();
            holder.tv = (TextView) convertView.findViewById(R.id.SelectOption);
            holder.sub = (TextView) convertView.findViewById(R.id.subitem);
            holder.chkbox = (CheckBox) convertView.findViewById(R.id.checkbox);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tv.setText(mListItems.get(position));
        holder.sub.setText(sub.get(position));

        final int position1 = position;

        //whenever the checkbox is clicked the selected values textview is updated with new selected values
        holder.chkbox.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                setText(position1);
            }
        });

        if(checkSelected[position])
            holder.chkbox.setChecked(true);
        else
            holder.chkbox.setChecked(false);
        return convertView;
    }


    /*
     * Function which updates the selected values display and information(checkSelected[])
     * */
    private void setText(int position1){
        if (!checkSelected[position1]) {
            checkSelected[position1] = true;
            selectedCount++;
        } else {
            checkSelected[position1] = false;
            selectedCount--;
        }

        if (selectedCount == 0) {
            mSelectedItems.setText(dropDownCheckBox.origtxt);
        } else if (selectedCount == 1) {
            for (int i = 0; i < checkSelected.length; i++) {
                if (checkSelected[i] == true) {
                    firstSelected = mListItems.get(i);
                    break;
                }
            }
            mSelectedItems.setText(firstSelected);
            setSelected(firstSelected);
        } else if (selectedCount > 1) {
            for (int i = 0; i < checkSelected.length; i++) {
                if (checkSelected[i] == true) {
                    firstSelected = mListItems.get(i);
                    break;
                }
            }
            mSelectedItems.setText(firstSelected + " & "+ (selectedCount - 1) + " more");
            setSelected(firstSelected + " & "+ (selectedCount - 1) + " more");
        }
    }

    private class ViewHolder {
        TextView tv;
        TextView sub;
        CheckBox chkbox;
    }
}