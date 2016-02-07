package dreamlinedesign.winecognoscenti.adapters;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.util.ArrayList;

import dreamlinedesign.winecognoscenti.MainActivity;
import dreamlinedesign.winecognoscenti.R;

/**
 * Created by GeEEE on 2016-02-05.
 */
public class DropDownCheckBox {

    private ArrayList<String> items = new ArrayList<String>();
    private ArrayList<String> sub = new ArrayList<String>();

    private Boolean[] checkSelected;
    private PopupWindow pw;
    private Boolean expanded;
    private TextView tv;
    private Button createButton;
    private View Layout;
    private MainActivity mainActivity;
    private LinearLayout popup;
    private ListView list;
    private Context context;

    public DropDownListAdapter getAdapter() {
        return adapter;
    }

    public void setAdapter(DropDownListAdapter adapter) {
        this.adapter = adapter;
    }

    private DropDownListAdapter adapter;


    public void setExpanded(Boolean expanded) {
        this.expanded = expanded;
    }

    public TextView getTv() {
        return tv;
    }

    public ArrayList<String> getItems() {
        return items;
    }

    public PopupWindow getPw() {
        return pw;
    }

    public Boolean getExpanded() {
        return expanded;
    }

    public View getLayout() {
        return Layout;
    }

    public LinearLayout getPopup() {
        return popup;
    }

    public ListView getList() {
        return list;
    }

    public Boolean[] getCheckSelected() {
        return checkSelected;
    }

    public void setCheckSelected(Boolean[] checkSelected) {
        this.checkSelected = checkSelected;
    }

    public DropDownCheckBox(Context context, ArrayList<String> items, ArrayList<String> sub, View Layout, MainActivity mainActivity) {
        this.Layout = Layout;
        LayoutInflater inflater = (LayoutInflater) mainActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.sub = sub;
        this.popup = (LinearLayout) inflater.inflate(R.layout.pop_up_window, (ViewGroup) Layout.findViewById(R.id.PopUpView));

        this.pw = new PopupWindow(popup, ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        this.items.addAll(items);
        this.tv = (TextView) Layout.findViewById(R.id.SelectBox);
        this.createButton = (Button) Layout.findViewById(R.id.create);
        this.mainActivity = mainActivity;
        this.list = (ListView) popup.findViewById(R.id.dropDownList);
        this.context = context;
        DropDownCheckBox c = this;
        checkSelected = new Boolean[this.items.size()];
        for (int i = 0; i < checkSelected.length; i++) {
            checkSelected[i] = false;
        }

        this.expanded = false;
        adapter = new DropDownListAdapter(context, items,sub, tv, checkSelected, this);
        /*tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!expanded){
                    //display all selected values
                    String selected = "";
                    int flag = 0;
                    for (int i = 0; i < DropDownCheckBox.items.size(); i++) {
                        if (checkSelected[i] == true) {
                            selected += DropDownCheckBox.items.get(i);
                            selected += ", ";
                            flag = 1;
                        }
                    }
                    if(flag==1) {
                        DropDownCheckBox.tv.setText(selected);
                        expanded = true;
                    }
                }
                else{
                    //display shortened representation of selected values
                    DropDownCheckBox.tv.setText(DropDownListAdapter.getSelected());
                    expanded = false;
                }
            }
        });*/

        /*createButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub


                initiatePopUp(DropDownCheckBox.items,DropDownCheckBox.tv, DropDownCheckBox.Layout);
            }


        });*/

    }

    public View.OnClickListener returnTVOnclick() {

        View.OnClickListener tvClick = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (!expanded) {
                    //display all selected values
                    String selected = "";
                    int flag = 0;
                    for (int i = 0; i < items.size(); i++) {
                        if (checkSelected[i] == true) {
                            selected += items.get(i);
                            selected += ", ";
                            flag = 1;
                        }
                    }
                    if (flag == 1) {
                        tv.setText(selected);
                        expanded = true;
                    }
                } else {
                    //display shortened representation of selected values
                    tv.setText(adapter.getSelected());
                    expanded = false;
                }
            }
        };

        return tvClick;

    }

    public View.OnClickListener returnbtnclik() {
        View.OnClickListener btnClick = new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //checkSelected = mainActivity.initiatePopUp(items,tv,Layout,checkSelected);

                LayoutInflater inflater = (LayoutInflater) mainActivity.getSystemService(context.LAYOUT_INFLATER_SERVICE);
                //get the view to which drop-down layout is to be anchored
                pw = new PopupWindow(popup, ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);

                //Pop-up window background cannot be null if we want the pop-up to listen touch events outside its window
                pw.setBackgroundDrawable(new BitmapDrawable());
                pw.setTouchable(true);

                //let pop-up be informed about touch events outside its window. This  should be done before setting the content of pop-up
                pw.setOutsideTouchable(true);
                pw.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);

                //dismiss the pop-up i.e. drop-down when touched anywhere outside the pop-up
                pw.setTouchInterceptor(new View.OnTouchListener() {

                    public boolean onTouch(View v, MotionEvent event) {
                        // TODO Auto-generated method stub
                        if (event.getAction() == MotionEvent.ACTION_OUTSIDE) {
                            pw.dismiss();
                            return true;
                        }
                        return false;
                    }
                });

                //provide the source layout for drop-down
                pw.setContentView(popup);

                //anchor the drop-down to bottom-left corner of 'layout1'
                pw.showAsDropDown(mainActivity.layout1);

                //populate the drop-down list
                list.setAdapter(adapter);


            }
        };
        return btnClick;
    }
}

    /*private void initiatePopUp(ArrayList<String> items, TextView tv, View layout) {
        LayoutInflater inflater = (LayoutInflater)this.mainActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //get the pop-up window i.e.  drop-down layout

        //get the view to which drop-down layout is to be anchored
        pw = new PopupWindow(this.popup, ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);

        //Pop-up window background cannot be null if we want the pop-up to listen touch events outside its window
        pw.setBackgroundDrawable(new BitmapDrawable());
        pw.setTouchable(true);

        //let pop-up be informed about touch events outside its window. This  should be done before setting the content of pop-up
        pw.setOutsideTouchable(true);
        pw.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);

        //dismiss the pop-up i.e. drop-down when touched anywhere outside the pop-up
        pw.setTouchInterceptor(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                if (event.getAction() == MotionEvent.ACTION_OUTSIDE) {
                    pw.dismiss();
                    return true;
                }
                return false;
            }
        });

        //provide the source layout for drop-down
        pw.setContentView(popup);

        //anchor the drop-down to bottom-left corner of 'layout1'
        pw.showAsDropDown(layout);

        //populate the drop-down list
         adapter = new DropDownListAdapter(this.context, this.items, this.tv, checkSelected);
        this.list.setAdapter(adapter);
        checkSelected = adapter.checkSelected;

    }*/

